package CodingRecipies.Avoid_if_else_if_command_pattern.good.executors;

import CodingRecipies.Avoid_if_else_if_command_pattern.other.Command;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;

public class BalanceCommandExecutor extends CommandExecutor {

    public static final String commandName = "balance";

    public BalanceCommandExecutor(Database database) {
        super(database);
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName().equals(commandName);
    }

    @Override
    protected boolean isValidCommand(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        return database.getUserBalance(user).toString();
    }
}
