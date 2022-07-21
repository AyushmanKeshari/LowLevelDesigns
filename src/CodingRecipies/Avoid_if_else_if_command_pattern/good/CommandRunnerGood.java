package CodingRecipies.Avoid_if_else_if_command_pattern.good;

import CodingRecipies.Avoid_if_else_if_command_pattern.good.executors.CommandExecutor;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandRunnerGood {

    List<CommandExecutor> executorList;

    public CommandRunnerGood(List<CommandExecutor> commandExecutors) {
        this.executorList = commandExecutors;
    }

    public String runCommand(Command command) {
        for (CommandExecutor commandExecutor : executorList) {
            if (commandExecutor.isApplicable(command)) {
                return commandExecutor.execute(command);
            }
        }

        return "Invalid Command";
    }
}
