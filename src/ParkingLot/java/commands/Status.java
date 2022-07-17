package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.model.Car;
import ParkingLot.java.model.Command;
import ParkingLot.java.model.Slot;
import ParkingLot.java.service.ParkingLotService;

import java.util.List;

public class Status extends CommandExecutor {

    public static final String commandName = "status";

    public Status(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        List<Slot> occupiedSlotList = parkingLotService.getOccupiedSlots();

        if(occupiedSlotList.isEmpty()) {
            outputPrinter.parkingLotEmpty();
            return;
        }

        outputPrinter.statusHeader();
        for(Slot slot : occupiedSlotList){
            Car parkedCar = slot.getParkedCar();
            String slotNumber = slot.getSlotNumber().toString();

            outputPrinter.printWithNewLine(slotNumber + "             " + parkedCar.getRegistrationID()
                    + "           " + parkedCar.getColor());
        }

    }

    //Can be used to apply padding
    private static String padString(final String word, final int length) {
        String newWord = word;
        for(int count = word.length(); count < length; count++) {
            newWord = newWord + " ";
        }
        return newWord;
    }
}
