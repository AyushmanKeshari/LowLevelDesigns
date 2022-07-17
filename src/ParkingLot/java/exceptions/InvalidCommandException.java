package ParkingLot.java.exceptions;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {
        super("This is an invalid command.");
    }
}
