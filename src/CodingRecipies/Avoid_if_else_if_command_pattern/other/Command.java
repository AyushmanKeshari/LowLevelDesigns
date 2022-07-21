package CodingRecipies.Avoid_if_else_if_command_pattern.other;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Command {
    String name;
    List<String> params;
}
