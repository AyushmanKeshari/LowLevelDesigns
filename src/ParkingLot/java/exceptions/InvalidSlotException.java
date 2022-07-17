package ParkingLot.java.exceptions;

public class InvalidSlotException extends ParkingLotException {

    public InvalidSlotException() {
        super("Invalid Slot Requested");
    }
}
