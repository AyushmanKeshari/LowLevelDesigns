package CodingRecipies.Avoid_if_else_if_command_pattern;

import CodingRecipies.Avoid_if_else_if_command_pattern.other.Command;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.RechargeProvider;

import java.util.List;

public class TestHelpers {
    static public Database getTestDatabase() {
        return new Database();
    }

    static public RechargeProvider getTestRechargeProvider() {
        return new RechargeProvider();
    }

    static public String getTestUser() {
        return "test-user";
    }

    static public Command getTestBalanceCommand(List params) {
        return new Command("balance", params);
    }

    static public Command getTestRechargeCommand(List params) {
        return new Command("recharge", params);
    }
}
