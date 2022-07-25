package MultiLevelCache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LevelCacheData {
    private int readTime;
    private int writeTime;
}
