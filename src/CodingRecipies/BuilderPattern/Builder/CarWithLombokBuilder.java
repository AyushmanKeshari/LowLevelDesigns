package CodingRecipies.BuilderPattern.Builder;

import CodingRecipies.BuilderPattern.CarComponents.*;
import lombok.Builder;

import java.util.List;

@Builder
public class CarWithLombokBuilder {
    private Engine engine;
    private Fuel fuel;
    private List<Seat> seats;
    private Steering steering;

    //Optional Properties
    private AirBag airBag;
    private CentralLock centralLock;
    private MusicSystem musicSystem;
    private SunRoof sunRoof;
}
