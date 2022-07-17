package ParkingLot.java.model;

import ParkingLot.java.exceptions.InvalidSlotException;
import ParkingLot.java.exceptions.ParkingLotException;
import ParkingLot.java.exceptions.SlotAlreadyOccupiedException;

import java.util.HashMap;

/**
 * Model object to represent the functioning of a parking lot.
 */
public class ParkingLot {

    private final int MAX_CAPACITY = 10000;
    private final int capacity;
    private final HashMap<Integer, Slot> slots;

    public ParkingLot(int capacity) {
        if (capacity >= MAX_CAPACITY || capacity < 0) {
            throw new ParkingLotException("Invalid capacity given for parking lot");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public HashMap<Integer, Slot> getSlots() {
        return slots;
    }

    private Slot getSlot(Integer slotNumber) {
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new InvalidSlotException();
        }

        HashMap<Integer, Slot> allSlots = getSlots();
        if (!allSlots.containsKey(slotNumber)) {
            allSlots.put(slotNumber, new Slot(slotNumber));
        }
        return allSlots.get(slotNumber);
    }

    public Slot park(Car car, Integer slotNumber) {
        Slot slot = getSlot(slotNumber);

        if (!slot.isAvailable()) {
            throw new SlotAlreadyOccupiedException();
        }
        slot.assignCar(car);
        return slot;
    }

    public Slot makeSlotFree(Integer slotNumber) {
        Slot slot = getSlot(slotNumber);
        slot.unAssignCar();
        return slot;
    }
}
