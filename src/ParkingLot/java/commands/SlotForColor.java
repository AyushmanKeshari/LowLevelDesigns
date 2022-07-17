package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.model.Command;
import ParkingLot.java.model.Slot;
import ParkingLot.java.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class SlotForColor extends CommandExecutor {

    public static final String commandName = "slot_numbers_for_cars_with_colour";

    public SlotForColor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        String color = command.getParams().get(0);

        List<Slot> slotsForColor  = parkingLotService.getSlotsByColor(color);

        if (slotsForColor .isEmpty()) {
            outputPrinter.notFound();
        } else {
//            for (Slot slot : slotsForColor ) {
//                outputPrinter.printWithNewLine(slot.getSlotNumber().toString());
//            }

            String result = slotsForColor.stream()
                    .map(slot -> slot.getSlotNumber().toString())
                    .collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }

    }
}
