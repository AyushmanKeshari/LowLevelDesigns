package ParkingLot.java.model;

public class Slot {

    private Integer slotNumber;
    private Car parkedCar;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void assignCar(Car car) {
        this.parkedCar = car;
    }

    public void unAssignCar() {
        this.parkedCar = null;
    }

    public boolean isAvailable() {
        return parkedCar == null;
    }

}
