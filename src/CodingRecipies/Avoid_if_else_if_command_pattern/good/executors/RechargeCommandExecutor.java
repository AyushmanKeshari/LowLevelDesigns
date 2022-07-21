package CodingRecipies.Avoid_if_else_if_command_pattern.good.executors;

import CodingRecipies.Avoid_if_else_if_command_pattern.other.Command;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.RechargeProvider;

public class RechargeCommandExecutor extends CommandExecutor {
    public final String commandName = "recharge";
    private final RechargeProvider rechargeProvider;

    public RechargeCommandExecutor(RechargeProvider rechargeProvider, Database database) {
        super(database);
        this.rechargeProvider = rechargeProvider;
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName().equals(commandName);
    }

    @Override
    protected boolean isValidCommand(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

        Integer userBalance = database.getUserBalance(user);
        if (userBalance < rechargeAmount) {
            return "Not sufficient balance";
        }
        rechargeProvider.recharge(user, rechargeAmount);
        return "Recharge Done";
    }
}
