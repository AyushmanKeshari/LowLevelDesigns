package MultiLevelCache.provider;

import MultiLevelCache.model.LevelCacheData;
import MultiLevelCache.model.ReadResponse;
import MultiLevelCache.model.WriteResponse;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

//CacheService -> L1 -> L2 -> L3 ->     next pointer.
//                C1    C2    C3...     Cache at each level.

//Different type of Cache can be at each layer. Ex. In Memory Cache,  Redis Cache.
@AllArgsConstructor
public class DefaultLevelCache<Key, Value> implements ILevelCache<Key, Value> {
    private final LevelCacheData levelCacheData;
    private final CacheProvider<Key, Value> cacheProvider;

    private final ILevelCache<Key, Value> next;

    @Override
    public WriteResponse set(Key key, Value value) {
        Double currTime = 0.0;

        Value currValue = cacheProvider.get(key);
        currTime += levelCacheData.getReadTime();

        if (!value.equals(currValue)) {
            cacheProvider.set(key, value);
            currTime += levelCacheData.getWriteTime();
        }

        currTime += next.set(key, value).getTimeTaken();

        return new WriteResponse(currTime);
    }

    @Override
    public ReadResponse<Value> get(Key key) {
        Double currTime = 0.0;
        Value currValue = cacheProvider.get(key);
        currTime += levelCacheData.getReadTime();

        if (currValue == null) {
            ReadResponse<Value> nextResponse = next.get(key);
            currTime += nextResponse.getTotalTime();
            currValue = nextResponse.getValue();

            if (currValue != null) {
                cacheProvider.set(key, currValue);
                currTime += levelCacheData.getWriteTime();
            }
        }
        return new ReadResponse<>(currValue, currTime);
    }

    @Override
    public List<Double> getUsages() {
        List<Double> usages;
        if (next == null) {
            usages = Collections.emptyList();
        } else {
            usages = next.getUsages();
        }
        usages.add(0, cacheProvider.getCurrentUsage());
        return usages;
    }
}
