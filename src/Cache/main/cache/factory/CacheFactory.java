package Cache.main.cache.factory;

import Cache.main.cache.Cache;
import Cache.main.cache.policies.LRUEvictionPolicy;
import Cache.main.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> getDefaultCache(int capacity) {
        return new Cache<Key, Value>(new HashMapBasedStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
