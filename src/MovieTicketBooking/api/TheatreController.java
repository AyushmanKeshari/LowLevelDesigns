package MovieTicketBooking.api;

import MovieTicketBooking.model.Screen;
import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Theatre;
import MovieTicketBooking.services.TheatreService;
import lombok.NonNull;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(@NonNull final TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(@NonNull final String name) {
        final Theatre theatre = theatreService.createTheatre(name);
        return theatre.getId();
    }

    public String createScreenInTheatre(@NonNull final String screenName, @NonNull final String theatreId) {
        final Theatre theatre = theatreService.getTheatre(theatreId);
        final Screen screen = theatreService.createScreenInTheatre(screenName, theatre);
        return screen.getScreenID();
    }

    public String createSeatInScreen(final int row, final int seatId, @NonNull final String screenID) {
        final Screen screen = theatreService.getScreen(screenID);
        final Seat seat = theatreService.createSeatInScreen(row, seatId, screen);
        return seat.id();
    }
}
