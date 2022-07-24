package MovieTicketBooking.api;

import MovieTicketBooking.model.Screen;
import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Show;
import MovieTicketBooking.services.BookingService;
import MovieTicketBooking.services.ShowService;
import MovieTicketBooking.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {

    private final ShowService showService;
    private final TheatreService theatreService;
    private final BookingService bookingService;

    public String createBooking(@NonNull final String userID, @NonNull final String showId
            , @NonNull final List<String> selectedSeatsID) {

        final Show show = showService.getShow(showId);
//        final Screen screen = theatreService.getScreen(show.getScreen().getScreenID());

        List<Seat> seats = selectedSeatsID.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userID, show, seats).getId();
    }
}
