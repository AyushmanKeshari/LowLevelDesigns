package ParkingLot.java;

import ParkingLot.java.commands.CommandExecutorFactory;
import ParkingLot.java.exceptions.InvalidModeException;
import ParkingLot.java.mode.FileMode;
import ParkingLot.java.mode.InteractiveMode;
import ParkingLot.java.mode.Mode;
import ParkingLot.java.service.ParkingLotService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParkingLotService parkingLotService = new ParkingLotService();
        CommandExecutorFactory executor = new CommandExecutorFactory(parkingLotService);

        startProcess(args, executor);
    }

    private static void startProcess(String[] args, CommandExecutorFactory executor) throws IOException {
        OutputPrinter outputPrinter = new OutputPrinter();

        if (isInteractiveMode(args)) {
            Mode mode = new InteractiveMode(executor, outputPrinter);
            mode.process();
        } else if (isFileInputMode(args)) {
            Mode mode = new FileMode(executor, outputPrinter, args[0]);
            mode.process();
        } else {
            throw new InvalidModeException();
        }
    }

    private static boolean isFileInputMode(String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(String[] args) {
        return args.length == 0;
    }
}
