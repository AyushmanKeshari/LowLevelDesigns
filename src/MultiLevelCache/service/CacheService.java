package MultiLevelCache.service;

import MultiLevelCache.model.ReadResponse;
import MultiLevelCache.model.WriteResponse;
import MultiLevelCache.provider.ILevelCache;
import lombok.NonNull;


public class CacheService<Key, Value> {
    private final ILevelCache<Key, Value> multiLevelCache;

    public CacheService(@NonNull final ILevelCache<Key, Value> multiLevelCache) {
        this.multiLevelCache = multiLevelCache;
    }

    public WriteResponse set(@NonNull final Key key, @NonNull final Value value) {
        return multiLevelCache.set(key, value);
    }

    public ReadResponse<Value> get(@NonNull final Key key) {
        return multiLevelCache.get(key);
    }

}
