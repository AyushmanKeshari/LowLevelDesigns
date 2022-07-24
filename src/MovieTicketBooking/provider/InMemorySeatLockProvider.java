package MovieTicketBooking.provider;

import MovieTicketBooking.exceptions.SeatTemporaryUnAvailableException;
import MovieTicketBooking.exceptions.ShowNotFoundException;
import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.SeatLock;
import MovieTicketBooking.model.Show;
import lombok.NonNull;

import java.util.*;

public class InMemorySeatLockProvider implements SeatLockProvider {

    private final int lockTimeOut; //Bonus Feature
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider(final int lockTimeOut) {
        this.lockTimeOut = lockTimeOut;
        this.locks = new HashMap<>();
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, String userID) {
        for (Seat seat : seats) {
            if (isSeatLocked(show, seat)) {
                throw new SeatTemporaryUnAvailableException();
            }
        }
        for (Seat seat : seats) {
            lockSeat(show, seat, userID, lockTimeOut);
        }
    }

    private void lockSeat(Show show, Seat seat, String userID, int lockTimeOut) {
        if (!locks.containsKey(show)) {
            locks.put(show, new HashMap<>());
        }
        final SeatLock seatLock = new SeatLock(seat, show, lockTimeOut, new Date(), userID);
        locks.get(show).put(seat, seatLock);
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return locks.containsKey(show)
                && locks.get(show).containsKey(seat)
                && !locks.get(show).get(seat).isLockExpired();
    }

    @Override
    public void unLockSeats(Show show, List<Seat> seats, String userID) {
        for (Seat seat : seats) {
            if (validateLock(show, seat, userID)) {
                unLockSeat(show, seat, userID);
            }
        }
    }

    private void unLockSeat(Show show, Seat seat, String userID) {
        if (!locks.containsKey(show)) {
            return;
        }
        locks.get(show).remove(seat);
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return isSeatLocked(show, seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        if (!locks.containsKey(show)) {
            return List.of();
        }

        List<Seat> lockedSeats = new ArrayList<>();

        for (Seat seat : locks.get(show).keySet()) {
            if (isSeatLocked(show, seat)) {
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }
}
