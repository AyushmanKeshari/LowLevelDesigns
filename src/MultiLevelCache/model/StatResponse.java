package MultiLevelCache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StatResponse {
    private final Double avgReadTime;
    private final Double avgWriteTime;
    private final List<Double> usages;
}
