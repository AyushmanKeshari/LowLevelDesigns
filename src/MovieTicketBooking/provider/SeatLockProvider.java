package MovieTicketBooking.provider;

import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Show;

import java.util.List;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seats, String userID);

    void unLockSeats(Show show, List<Seat> seats, String userID);

    boolean validateLock(Show show, Seat seat, String user);

    List<Seat> getLockedSeats(Show show);

}
