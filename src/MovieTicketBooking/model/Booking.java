package MovieTicketBooking.model;

import MovieTicketBooking.exceptions.InvalidBookingStateException;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Booking {
    private final String id;
    private final Show show;
    private final String user;
    private final List<Seat> bookedSeats;
    private BookingStatus bookingStatus;

    //Booking can be created only with the help of constructor.
    public Booking(@NonNull final String id, @NonNull final String user, @NonNull final Show show
            , @NonNull final List<Seat> bookedSeats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed(){
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if(this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidBookingStateException();
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if(this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidBookingStateException();
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }

}
