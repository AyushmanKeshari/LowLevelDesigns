package MovieTicketBooking.api;

import MovieTicketBooking.model.Booking;
import MovieTicketBooking.services.BookingService;
import MovieTicketBooking.services.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;
    private final BookingService bookingService;

    public void paymentFailed(@NonNull final String bookingID, @NonNull final String user) {
        Booking booking = bookingService.getBooking(bookingID);
        paymentService.processPaymentFailed(booking, user);
    }

    public void paymentSuccess(@NonNull final String bookingID, @NonNull final String user) {
        Booking booking = bookingService.getBooking(bookingID);
        bookingService.confirmBooking(booking, user);
    }
}
