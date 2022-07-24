package MovieTicketBooking.scenarios;

import MovieTicketBooking.api.*;
import MovieTicketBooking.provider.InMemorySeatLockProvider;
import MovieTicketBooking.services.*;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Assert;

public class BaseTests {
    protected BookingController bookingController;
    protected MovieController movieController;
    protected PaymentsController paymentsController;
    protected ShowController showController;
    protected TheatreController theatreController;

    protected void setUpControllers(int lockTimeOut, int allowedRetries) {
        final InMemorySeatLockProvider seatLockProvider = new InMemorySeatLockProvider(lockTimeOut);

        final BookingService bookingService = new BookingService(seatLockProvider);
        final MovieService movieService = new MovieService();
        final PaymentService paymentService = new PaymentService(allowedRetries, seatLockProvider);
        final ShowService showService = new ShowService();
        final TheatreService theatreService = new TheatreService();

        final SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(bookingService, seatLockProvider);

        bookingController = new BookingController(showService, theatreService, bookingService);
        movieController = new MovieController(movieService);
        paymentsController = new PaymentsController(paymentService, bookingService);
        showController = new ShowController(seatAvailabilityService, theatreService, movieService, showService);
        theatreController = new TheatreController(theatreService);
    }

    protected void validateSeatsList(List<String> seatsList, List<String> allSeatsInScreen, List<String> excludedSeats) {
        for (String includedSeat: allSeatsInScreen) {
            if (!excludedSeats.contains(includedSeat)) {
//                Assert.assertTrue(seatsList.contains(includedSeat));
            }
        }

        for (String excludedSeat: excludedSeats) {
//            Assert.assertFalse(seatsList.contains(excludedSeat));
        }
    }

    protected List<String> createSeats(TheatreController theatreController, String screen, int numRows, int numSeatsInRow) {
        List<String> seats = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            for (int seatNo = 0; seatNo < numSeatsInRow; seatNo++) {
                String seat = theatreController.createSeatInScreen(row, seatNo, screen);
                seats.add(seat);
            }
        }
        return seats;
    }

    protected String setupScreen() {
        final String theatre = theatreController.createTheatre("Theatre 1");
        return theatreController.createScreenInTheatre("Screen 1", theatre);
    }
}
