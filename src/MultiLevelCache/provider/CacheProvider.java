package MultiLevelCache.provider;

import MultiLevelCache.exceptions.StorageFullException;
import MultiLevelCache.policy.EvictionPolicy;
import MultiLevelCache.storage.Storage;
import lombok.NonNull;

// Black box providing Caching functionality at each layer.
public class CacheProvider<Key, Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public CacheProvider(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void set(final Key key, final Value value) {
        try {
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            Key keyToRemove = evictionPolicy.evict();
            storage.remove(keyToRemove);
            set(key, value);
        }
    }

    public Value get(@NonNull final Key key) {
        evictionPolicy.keyAccessed(key);
        return storage.get(key);
    }
}
