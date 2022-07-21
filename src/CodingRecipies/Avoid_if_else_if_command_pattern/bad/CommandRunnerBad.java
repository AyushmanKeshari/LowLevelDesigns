package CodingRecipies.Avoid_if_else_if_command_pattern.bad;

import CodingRecipies.Avoid_if_else_if_command_pattern.other.Command;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.RechargeProvider;

public class CommandRunnerBad {
    final Database database;
    final RechargeProvider rechargeProvider;

    public CommandRunnerBad(Database database, RechargeProvider rechargeProvider) {
        this.database = database;
        this.rechargeProvider = rechargeProvider;
    }

    String runCommand(Command command) {
        if ("balance".equals(command.getName())) {
            if (command.getParams().size() != 1) {
                return "Invalid Command";
            }
            String user = command.getParams().get(0);
            return database.getUserBalance(user).toString();
        } else if ("recharge".equals(command.getName())) {
            if (command.getParams().size() != 2) {
                return "Invalid Command";
            }
            String user = command.getParams().get(0);
            Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

            Integer userBalance = database.getUserBalance(user);
            if (userBalance < rechargeAmount) {
                return "Not sufficient balance";
            }
            rechargeProvider.recharge(user, rechargeAmount);
            return "Recharge Done";
        }
//        else if ("addMoney".equals(command.getName())){
//
//        }
        else {
            return "Invalid command";
        }
    }
}
