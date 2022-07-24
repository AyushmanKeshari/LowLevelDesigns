package MovieTicketBooking.services;

import MovieTicketBooking.exceptions.BadRequestException;
import MovieTicketBooking.model.Booking;
import MovieTicketBooking.provider.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    private final Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;
    private final SeatLockProvider seatLockProvider;

    public PaymentService(Integer allowedRetries, SeatLockProvider seatLockProvider) {
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
        this.bookingFailures = new HashMap<>();
    }

    public void processPaymentFailed(Booking booking, String user) {
        if (!booking.getUser().equals(user)) {
            throw new BadRequestException();
        }

        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }

        Integer currentFailureCount = bookingFailures.get(booking);
        Integer newFailureCount = currentFailureCount + 1;
        bookingFailures.put(booking, newFailureCount);

        if (newFailureCount > allowedRetries) {
            seatLockProvider.unLockSeats(booking.getShow(), booking.getBookedSeats(), user);
        }
    }
}
