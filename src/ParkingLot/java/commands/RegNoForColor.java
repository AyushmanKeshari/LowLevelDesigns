package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.model.Command;
import ParkingLot.java.model.Slot;
import ParkingLot.java.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class RegNoForColor extends CommandExecutor {

    public static final String commandName = "registration_numbers_for_cars_with_colour";

    public RegNoForColor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        String color = command.getParams().get(0);
        List<Slot> slotsForColor = parkingLotService.getSlotsByColor(color);

        if (slotsForColor.isEmpty()) {
            outputPrinter.notFound();
        } else {
            String result = slotsForColor.stream()
                    .map(slot -> slot.getParkedCar().getRegistrationID())
                    .collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }
    }
}
