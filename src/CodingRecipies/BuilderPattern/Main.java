package CodingRecipies.BuilderPattern;

import CodingRecipies.BuilderPattern.Builder.CarWithBuilder;
import CodingRecipies.BuilderPattern.Builder.CarWithLombokBuilder;
import CodingRecipies.BuilderPattern.CarComponents.*;
import CodingRecipies.BuilderPattern.Constructors.CarWithConstructor;
import CodingRecipies.BuilderPattern.Setters.CarWithSetters;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Engine engine = new Engine();
        final List<Seat> seats = new ArrayList<>();
        final Steering steering = new Steering();
        final SunRoof sunRoof = new SunRoof();
        final AirBag airBags = new AirBag();
        final MusicSystem musicSystem = new MusicSystem();
        final CentralLock centralLock = new CentralLock();


        /**
         * Constructor
         * 1. So many nulls you will to put.
         * 2. Makes constructor ugly.
         */
        CarWithConstructor carWithConstructor = new CarWithConstructor(engine, Fuel.PETROL, seats, steering,
                null, null, null, null);

        CarWithConstructor carWithConstructor1 = new CarWithConstructor(engine, Fuel.PETROL, seats, steering,
                null, centralLock, null, null);


        /**
         * Setters
         * 1. You can make half-baked object by missing required properties.
         * 2. Object becomes mutable. You can change its properties even after its construction.
         */
        CarWithSetters carWithSetters = new CarWithSetters();
        carWithSetters.setEngine(engine);
        carWithSetters.setSteering(steering);
        // We forgot to set required properties seats and fuel.
        carWithSetters.setAirBag(airBags);
        carWithSetters.setMusicSystem(musicSystem);
        // Construction completes here.

        // We can just replace the engine with new one.
        carWithSetters.setEngine(new Engine());


        /**
         * Using builders
         * 1. Simple construction.
         * 2. Looks clean. More Readable
         * 3. Object remains immutable once it is build.
         */

        CarWithBuilder carWithBuilder = CarWithBuilder.builder()
                .withEngine(engine)
                .withFuel(Fuel.PETROL)
                .withSeats(seats)
                .withSteering(steering)
                .build();

        CarWithLombokBuilder carWithLombokBuilder = CarWithLombokBuilder.builder()
                .engine(engine)
                .airBag(airBags)
                .musicSystem(musicSystem)
                .steering(steering)
                .build();
    }
}
