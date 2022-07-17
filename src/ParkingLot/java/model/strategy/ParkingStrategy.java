package ParkingLot.java.model.strategy;

public interface ParkingStrategy {

    void addSlot(Integer slotNumber);
    void removeSlot(Integer slotNumber);
    Integer getNextSlot();

}
