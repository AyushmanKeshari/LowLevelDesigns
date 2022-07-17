package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.validator.IntegerValidator;
import ParkingLot.java.model.Command;
import ParkingLot.java.service.ParkingLotService;

public class Leave extends CommandExecutor {

    public static final String commandName = "leave";

    public Leave(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        int size = command.getParams().size();
        if (size != 1) return false;

        return IntegerValidator.isInteger(command.getParams().get(0));
    }

    @Override
    public void execute(Command command) {
        int slotNumber = Integer.parseInt(command.getParams().get(0));
        parkingLotService.leave(slotNumber);

        outputPrinter.printWithNewLine("Slot number " + slotNumber + " is free.");
    }
}
