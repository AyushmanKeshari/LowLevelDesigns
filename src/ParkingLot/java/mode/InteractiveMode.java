package ParkingLot.java.mode;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.commands.CommandExecutorFactory;
import ParkingLot.java.commands.Exit;
import ParkingLot.java.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mode running in which input commands are given from an interactive shell.
 */
public class InteractiveMode extends Mode {

    public InteractiveMode(CommandExecutorFactory factory, OutputPrinter outputPrinter) {
        super(factory, outputPrinter);
    }

    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            Command command = new Command(input);
            processCommand(command);
            if (command.getCommandName().equals(Exit.COMMAND_NAME)) {
                break;
            }
        }

    }
}
