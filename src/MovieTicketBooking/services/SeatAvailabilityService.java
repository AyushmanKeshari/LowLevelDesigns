package MovieTicketBooking.services;

import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Show;
import MovieTicketBooking.provider.SeatLockProvider;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SeatAvailabilityService {
    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> allSeats = show.screen().getSeats();
        List<Seat> unAvailableSeats = getUnavailableSeats(show);

        List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.remove(unAvailableSeats);
        return availableSeats;
    }

    private List<Seat> getUnavailableSeats(Show show) {
        List<Seat> unAvailableSeats = bookingService.getBookedSeats(show);
        unAvailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unAvailableSeats;
    }
}
