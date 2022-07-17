package ParkingLot.java.exceptions;

public class SlotAlreadyOccupiedException extends ParkingLotException {

    public SlotAlreadyOccupiedException() {
        super("Slot Already Occupied");
    }
}
