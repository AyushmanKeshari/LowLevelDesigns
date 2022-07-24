package MovieTicketBooking.model;

// Record : a new kind of type declaration.
// Like an enum , a record is a restricted form of a class.
// It's ideal for "plain data carriers," classes that contain data not meant to be altered.
// only the most fundamental methods such as constructors and accessors.

public record Seat(String id, int rowNumber, int seatNumber) {
}
