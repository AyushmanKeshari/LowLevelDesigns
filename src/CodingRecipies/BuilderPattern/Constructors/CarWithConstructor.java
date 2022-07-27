package CodingRecipies.BuilderPattern.Constructors;

import CodingRecipies.BuilderPattern.CarComponents.*;
import lombok.NonNull;

import java.util.List;

public class CarWithConstructor {
    //Required Properties
    private Engine engine;
    private Fuel fuel;
    private List<Seat> seats;
    private Steering steering;

    //Optional Properties
    private AirBag airBag;
    private CentralLock centralLock;
    private MusicSystem musicSystem;
    private SunRoof sunRoof;

    //Single Constructor
    public CarWithConstructor(@NonNull Engine engine, @NonNull Fuel fuel, @NonNull List<Seat> seats, @NonNull Steering steering
            , AirBag airBag, CentralLock centralLock, MusicSystem musicSystem, SunRoof sunRoof) {
        this.engine = engine;
        this.fuel = fuel;
        this.seats = seats;
        this.steering = steering;
        this.airBag = airBag;
        this.centralLock = centralLock;
        this.musicSystem = musicSystem;
        this.sunRoof = sunRoof;
    }

    // Multiple Constructors for each combination
    public CarWithConstructor(@NonNull Engine engine, @NonNull Fuel fuel, @NonNull List<Seat> seats, @NonNull Steering steering,
                              AirBag airBag) {
        this.engine = engine;
        this.fuel = fuel;
        this.seats = seats;
        this.steering = steering;
        this.airBag = airBag;
    }

    public CarWithConstructor(@NonNull Engine engine, @NonNull Fuel fuel, @NonNull List<Seat> seats, @NonNull Steering steering,
                              AirBag airBag, CentralLock centralLock) {
        this.engine = engine;
        this.fuel = fuel;
        this.seats = seats;
        this.steering = steering;
        this.airBag = airBag;
        this.centralLock = centralLock;
    }


}
