package CodingRecipies.Avoid_if_else_if_command_pattern.good.executors;

import CodingRecipies.Avoid_if_else_if_command_pattern.other.Command;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;

public abstract class CommandExecutor {
    protected Database database;

    public CommandExecutor(Database database) {
        this.database = database;
    }

    public String execute(Command command) {
        if (isValidCommand(command)) {
            return executeValidCommand(command);
        } else {
            return "Invalid command";
        }
    }

    public abstract boolean isApplicable(Command command);

    protected abstract boolean isValidCommand(Command command);

    protected abstract String executeValidCommand(Command command);

}
