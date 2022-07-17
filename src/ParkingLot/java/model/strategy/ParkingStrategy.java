package ParkingLot.java.model.strategy;

/**
 * Strategy which will be used to decide how slots will be used to park the car.
 */
public interface ParkingStrategy {

    void addSlot(Integer slotNumber);

    void removeSlot(Integer slotNumber);

    Integer getNextSlot();

}
