package ParkingLot.java.mode;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.commands.CommandExecutor;
import ParkingLot.java.commands.CommandExecutorFactory;
import ParkingLot.java.exceptions.InvalidCommandException;
import ParkingLot.java.model.Command;

import java.io.IOException;

public abstract class Mode {

    CommandExecutorFactory factory;
    OutputPrinter outputPrinter;

    public Mode(CommandExecutorFactory factory, OutputPrinter outputPrinter) {
        this.factory = factory;
        this.outputPrinter = outputPrinter;
    }

    public void processCommand(Command command) {
        CommandExecutor commandExecutor = factory.getCommandExecutor(command);
        if(commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }

    public abstract void process() throws IOException;

}
