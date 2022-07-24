package MovieTicketBooking.services;

import MovieTicketBooking.exceptions.ScreenNotFoundException;
import MovieTicketBooking.exceptions.SeatNotFoundException;
import MovieTicketBooking.exceptions.TheatreNotFoundException;
import MovieTicketBooking.model.Screen;
import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Theatre;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


//Contains all three services: Theatre service, Screen service and Seat Service.
public class TheatreService {
    private final Map<String, Theatre> theatres;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;

    public TheatreService() {
        theatres = new HashMap<>();
        screens = new HashMap<>();
        seats = new HashMap<>();
    }

    public Theatre createTheatre(@NonNull final String name) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, name);
        theatres.put(theatreId, theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(@NonNull final String name, @NonNull final Theatre theatre) {
        String screenID = UUID.randomUUID().toString();
        Screen screen = new Screen(screenID, name, theatre);
        screens.put(screenID, screen);
        theatre.addScreen(screen);  //Adding screen in theatre.
        return screen;
    }

    public Seat createSeatInScreen(final int rowNumber,final int seatNumber, @NonNull final Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, rowNumber, seatNumber);
        seats.put(seatId, seat);
        screen.addSeat(seat);   //Adding seat in screen.
        return seat;
    }

    public Theatre getTheatre(@NonNull final String theatreID) {
        if (!theatres.containsKey(theatreID)) {
            throw new TheatreNotFoundException();
        }
        return theatres.get(theatreID);
    }

    public Screen getScreen(@NonNull final String screenID) {
        if (!screens.containsKey(screenID)) {
            throw new ScreenNotFoundException();
        }
        return screens.get(screenID);
    }

    public Seat getSeat(@NonNull final String seatID) {
        if (!seats.containsKey(seatID)) {
            throw new SeatNotFoundException();
        }
        return seats.get(seatID);
    }

}
