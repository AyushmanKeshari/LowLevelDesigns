package MovieTicketBooking.model;

import java.util.Date;

public record Show(String id, Movie movie, Screen screen, Date startTime, int durationInSecond) {
}
