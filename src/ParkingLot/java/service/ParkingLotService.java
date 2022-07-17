package ParkingLot.java.service;

import ParkingLot.java.exceptions.ParkingLotException;
import ParkingLot.java.model.Car;
import ParkingLot.java.model.ParkingLot;
import ParkingLot.java.model.Slot;
import ParkingLot.java.model.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParking(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) {
            throw new ParkingLotException("Parking lot doesn't exists");
        }
    }

    public Integer park(Car car) {
        validateParkingLotExists();
        Integer nextFreeSlot = parkingStrategy.getNextSlot();
        parkingLot.park(car, nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    public void leave(int slotNumber) {
        validateParkingLotExists();
        parkingStrategy.addSlot(slotNumber);
        parkingLot.makeSlotFree(slotNumber);
    }

    public List<Slot> getOccupiedSlots() {
        validateParkingLotExists();
        List<Slot> occupiedSlotList = new ArrayList<>();
        HashMap<Integer, Slot> slotList = parkingLot.getSlots();

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            if (slotList.containsKey(i)) {
                Slot slot = slotList.get(i);
                if (!slot.isAvailable()) {
                    occupiedSlotList.add(slotList.get(i));
                }
            }
        }
        return occupiedSlotList;
    }

    public List<Slot> getSlotsByColor(String color) {
        validateParkingLotExists();
        List<Slot> occupiedSlotList = getOccupiedSlots();
        return occupiedSlotList.stream()
                .filter(slot -> slot.getParkedCar().getColor().equals(color))
                .collect(Collectors.toList());
    }


}
