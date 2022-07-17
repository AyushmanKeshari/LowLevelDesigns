package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.model.Command;
import ParkingLot.java.service.ParkingLotService;

public class Exit extends CommandExecutor {

    public static final String COMMAND_NAME = "exit";

    public Exit(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        outputPrinter.end();
    }
}
