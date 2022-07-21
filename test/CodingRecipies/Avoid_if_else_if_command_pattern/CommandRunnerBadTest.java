package CodingRecipies.Avoid_if_else_if_command_pattern;

import CodingRecipies.Avoid_if_else_if_command_pattern.bad.CommandRunnerBad;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.Database;
import CodingRecipies.Avoid_if_else_if_command_pattern.other.RechargeProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandRunnerBadTest {

    CommandRunnerBad commandRunnerBad;

    @BeforeEach
    void setUp() {
        commandRunnerBad = new CommandRunnerBad(new Database(), new RechargeProvider());
    }

    @Test
    void testBalanceCheck() {
//        String balance = commandRunnerBad.runCommand(getTestBalanceCommand(ImmutableList.of(getTestUser())));
//        assertEquals("1000", balance);
    }
}
