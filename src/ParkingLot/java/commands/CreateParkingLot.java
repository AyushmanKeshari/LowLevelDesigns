package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.validator.IntegerValidator;
import ParkingLot.java.model.Command;
import ParkingLot.java.model.ParkingLot;
import ParkingLot.java.model.strategy.NaturalOrderingParkingStrategy;
import ParkingLot.java.service.ParkingLotService;

public class CreateParkingLot extends CommandExecutor {

    public static final String commandName = "create_parking_lot";

    public CreateParkingLot(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
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
        int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParking(parkingLot, new NaturalOrderingParkingStrategy());

        outputPrinter.printWithNewLine("Created a parking lot with " + parkingLot.getCapacity() + " slots.");
    }
}
