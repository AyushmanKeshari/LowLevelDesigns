package MovieTicketBooking.services;

import MovieTicketBooking.exceptions.MovieNotFoundException;
import MovieTicketBooking.model.Movie;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private final Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public Movie createMovie(@NonNull final String movieName) {
        String movieID = UUID.randomUUID().toString();
        Movie movie = new Movie(movieID, movieName);
        movies.put(movieID, movie);
        return movie;
    }

    public Movie getMovie(@NonNull final String movieID) {
        if (!movies.containsKey(movieID)) {
            throw new MovieNotFoundException();
        }
        return movies.get(movieID);
    }
}
