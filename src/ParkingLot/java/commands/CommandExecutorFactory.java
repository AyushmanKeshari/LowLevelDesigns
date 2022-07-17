package ParkingLot.java.commands;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.exceptions.InvalidCommandException;
import ParkingLot.java.model.Command;
import ParkingLot.java.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;


/**
 * Factory to get correct {@link CommandExecutor} from a given command.
 */
public class CommandExecutorFactory {

    private ParkingLotService parkingLotService;
    private Map<String, CommandExecutor> commands;

    public CommandExecutorFactory(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
        this.commands = new HashMap<>();
        addCommands();
    }

    private void addCommands() {
        final OutputPrinter outputPrinter = new OutputPrinter();

        commands.put(CreateParkingLot.commandName, new CreateParkingLot(parkingLotService, outputPrinter));

        commands.put(Park.commandName, new Park(parkingLotService, outputPrinter));

        commands.put(Leave.commandName, new Leave(parkingLotService, outputPrinter));

        commands.put(Status.commandName, new Status(parkingLotService, outputPrinter));

        commands.put(SlotForRegNo.commandName, new SlotForRegNo(parkingLotService, outputPrinter));

        commands.put(SlotForColor.commandName, new SlotForColor(parkingLotService, outputPrinter));

        commands.put(RegNoForColor.commandName, new RegNoForColor(parkingLotService, outputPrinter));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
