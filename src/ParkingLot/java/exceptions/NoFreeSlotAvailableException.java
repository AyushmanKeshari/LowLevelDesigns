package ParkingLot.java.exceptions;

public class NoFreeSlotAvailableException extends ParkingLotException {

    public NoFreeSlotAvailableException() {
        super("No free slot is available.");
    }
}
