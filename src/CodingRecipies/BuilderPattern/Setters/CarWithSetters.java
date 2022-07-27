package CodingRecipies.BuilderPattern.Setters;

import CodingRecipies.BuilderPattern.CarComponents.*;

import java.util.List;

public class CarWithSetters {
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

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setSteering(Steering steering) {
        this.steering = steering;
    }

    public void setAirBag(AirBag airBag) {
        this.airBag = airBag;
    }

    public void setCentralLock(CentralLock centralLock) {
        this.centralLock = centralLock;
    }

    public void setMusicSystem(MusicSystem musicSystem) {
        this.musicSystem = musicSystem;
    }

    public void setSunRoof(SunRoof sunRoof) {
        this.sunRoof = sunRoof;
    }

}
