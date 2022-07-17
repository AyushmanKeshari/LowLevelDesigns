package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.model.Command;
import ParkingLot.java.service.ParkingLotService;

public abstract class CommandExecutor {
    ParkingLotService parkingLotService;
    OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);

}
