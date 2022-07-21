package CodingRecipies.Avoid_if_else_if_command_pattern;

import CodingRecipies.Avoid_if_else_if_command_pattern.good.CommandRunnerGood;
import CodingRecipies.Avoid_if_else_if_command_pattern.good.executors.*;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static CodingRecipies.Avoid_if_else_if_command_pattern.TestHelpers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandRunnerGoodTest {

    private CommandRunnerGood commandRunnerGood;

    private Database database;

    @BeforeEach
    public void setUp() {

        database = getTestDatabase();

        BalanceCommandExecutor balanceCommandExecutor = new BalanceCommandExecutor(database);
        RechargeCommandExecutor rechargeCommandExecutor = new RechargeCommandExecutor(getTestRechargeProvider(), database);

        List<CommandExecutor> commandExecutors = new ArrayList<>();
        commandExecutors.add(balanceCommandExecutor);
        commandExecutors.add(rechargeCommandExecutor);

        commandRunnerGood = new CommandRunnerGood(commandExecutors);
    }

    @Test
    public void runTest() {
        String balance = commandRunnerGood.runCommand(getTestBalanceCommand(
                List.of(new String[]{database.getUserBalance(getTestUser()).toString()})));
        assertEquals("1000", balance);

        String recharge = commandRunnerGood.runCommand(getTestRechargeCommand(
                List.of(new String[]{getTestUser(), "100"})));
        assertEquals("Recharge Done", recharge);

    }
}
