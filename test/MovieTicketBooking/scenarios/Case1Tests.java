package MovieTicketBooking.scenarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class Case1Tests extends BaseTests {
    @BeforeEach
    public void setUp(){
        setUpControllers(10, 0);
    }

    @Test
    public void userDoesNotGetTemporaryUnavailableSeats() {
        String user1 = "user1";
        String user2 = "user2";

        final String movie = movieController.createMovie("movie 1");
        final String screen = setupScreen();
        final List<String> seats = createSeats(theatreController, screen, 2, 10);

        final String show = showController.createShow(movie, screen, new Date(), 2*60*60);
        List<String> u1AvailableSeats = showController.getAvailableSeats(show);

        // Validate that seats u1 received has all screen seats
        validateSeatsList(u1AvailableSeats, seats, List.of());

        List<String> u1SelectedSeats = List.of(
                seats.get(0),
                seats.get(2),
                seats.get(5),
                seats.get(10)
        );
    }
}
