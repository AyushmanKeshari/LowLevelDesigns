package MovieTicketBooking.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Theatre {
    private final String id;
    private final String theatreName;
    private final List<Screen> screens;

    //final : Non-access modifier. Makes them non-changeable;
    public Theatre(final String id, String name) {
        this.id = id;
        this.theatreName = name;
        screens = new ArrayList<>();
    }

    public void addScreen(@NonNull final Screen screen) {
        screens.add(screen);
    }
}
