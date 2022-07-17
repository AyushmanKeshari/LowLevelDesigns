package ParkingLot.java.exceptions;

public class InvalidModeException extends RuntimeException {

    public InvalidModeException() {
        super("Invalid mode selected.");
    }
}
