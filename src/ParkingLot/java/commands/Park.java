package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.exceptions.NoFreeSlotAvailableException;
import ParkingLot.java.model.Car;
import ParkingLot.java.model.Command;
import ParkingLot.java.service.ParkingLotService;

public class Park extends CommandExecutor {

    public static final String commandName = "park";

    public Park(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {
        Car car = new Car(command.getParams().get(0), command.getParams().get(1));

        try {
            Integer slotNumber = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Allocated car to slot number: " + slotNumber);
        } catch (NoFreeSlotAvailableException e) {
            outputPrinter.parkingLotFull();
        }
    }
}
