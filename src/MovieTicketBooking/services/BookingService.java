package MovieTicketBooking.services;

import MovieTicketBooking.exceptions.BadRequestException;
import MovieTicketBooking.exceptions.BookingNotFoundException;
import MovieTicketBooking.exceptions.SeatPermanentlyUnavailableException;
import MovieTicketBooking.model.Booking;
import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Show;
import MovieTicketBooking.provider.SeatLockProvider;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private final Map<String, Booking> showBookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.showBookings = new HashMap<>();
    }

    public Booking getBooking(@NonNull String bookingId) {
        if (!showBookings.containsKey(bookingId)) {
            throw new BookingNotFoundException();
        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(@NonNull final Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : showBookings.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }
        return response;
    }

    public Booking createBooking(@NonNull final String userID, @NonNull final Show show
            , @NonNull final List<Seat> seats) {

        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new SeatPermanentlyUnavailableException();
        }


        seatLockProvider.lockSeats(show, seats, userID);


        final String bookingID = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingID, userID, show, seats);
        showBookings.put(bookingID, newBooking);
        return newBooking;

        //TODO: create timer for booking expiry
    }

    public List<Seat> getBookedSeats(@NonNull final Show show) {
        List<Booking> allBookings = getAllBookings(show);
        return allBookings.stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getBookedSeats)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private boolean isAnySeatAlreadyBooked(final Show show, List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }

    public void confirmBooking(Booking booking, String user) {
        if(!booking.getUser().equals(user)) {
            throw new BadRequestException();
        }

        //Check if still holding the lock
        for (Seat seat : booking.getBookedSeats()) {
            if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new BadRequestException();
            }
        }

        booking.confirmBooking();
    }
}
