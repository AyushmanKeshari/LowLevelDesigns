package MovieTicketBooking.api;

import MovieTicketBooking.model.Movie;
import MovieTicketBooking.model.Screen;
import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Show;
import MovieTicketBooking.services.MovieService;
import MovieTicketBooking.services.SeatAvailabilityService;
import MovieTicketBooking.services.ShowService;
import MovieTicketBooking.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowController {

    private final SeatAvailabilityService seatAvailabilityService;
    private final TheatreService theatreService;
    private final MovieService movieService;
    private final ShowService showService;


    public String createShow(@NonNull final String movieID, @NonNull final String screenID
            , @NonNull final Date startTime, final int durationInSeconds) {

        final Movie movie = movieService.getMovie(movieID);
        final Screen screen = theatreService.getScreen(screenID);

        final Show show = showService.createShow(movie, screen, startTime, durationInSeconds);
        return show.id();
    }

    public List<String> getAvailableSeats(@NonNull final String showID) {
        final Show show = showService.getShow(showID);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::id).collect(Collectors.toList());
    }
}
