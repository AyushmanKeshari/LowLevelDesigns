package MovieTicketBooking.services;

import MovieTicketBooking.exceptions.ShowCreationNotAllowed;
import MovieTicketBooking.exceptions.ShowNotFoundException;
import MovieTicketBooking.model.Movie;
import MovieTicketBooking.model.Screen;
import MovieTicketBooking.model.Show;
import lombok.NonNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowService {
    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show createShow(@NonNull final Movie movie, @NonNull final Screen screen
            , @NonNull final Date startTime, final int durationInSeconds) {

        if (!checkIfShowCreationIsAllowed(screen, startTime, durationInSeconds)) {
            throw new ShowCreationNotAllowed();
        }

        String showId = UUID.randomUUID().toString();
        Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        shows.put(showId, show);
        return show;
    }

    public Show getShow(@NonNull final String showID) {
        if (!shows.containsKey(showID)) {
            throw new ShowNotFoundException();
        }
        return shows.get(showID);
    }

    private boolean checkIfShowCreationIsAllowed(Screen screen, Date startTime, int durationInSeconds) {
        //TODO : Implement - Return true if screen is available for the selected time interval.

        return true;
    }
}
