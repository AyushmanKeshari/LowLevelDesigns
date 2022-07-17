package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.model.Command;
import ParkingLot.java.model.Slot;
import ParkingLot.java.service.ParkingLotService;

import java.util.List;
import java.util.Optional;

public class SlotForRegNo extends CommandExecutor {

    public static final String commandName = "slot_number_for_registration_number";

    public SlotForRegNo(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
        final String regNumberToFind = command.getParams().get(0);

        Optional<Slot> foundSlot = occupiedSlots.stream()
                .filter(slot -> slot.getParkedCar().getRegistrationID().equals(regNumberToFind))
                .findFirst();

        if (foundSlot.isPresent()) {
            outputPrinter.printWithNewLine(foundSlot.get().getSlotNumber().toString());
        } else {
            outputPrinter.notFound();
        }
    }
}
