package MovieTicketBooking.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Screen {
    private final String screenID;
    private final String screenName;
    private final Theatre theatre;

    private final List<Seat> seats;
    //final does not mean immutable list. It prevents from assigning new value of ArrayList<>().


    public Screen(@NonNull final String screenID, @NonNull final String name, @NonNull Theatre theatre){
        this.screenID = screenID;
        this.screenName = name;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
//        List<Seat> unmodifiableList = Collections.unmodifiableList(seats);    //To Create Immutable List
    }

    public void addSeat(@NonNull final Seat seat) {
        seats.add(seat);
    }
}
