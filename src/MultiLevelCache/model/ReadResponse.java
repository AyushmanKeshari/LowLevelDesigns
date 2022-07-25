package MultiLevelCache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReadResponse<Value> {
    private Value value;
    private Double totalTime;
}
