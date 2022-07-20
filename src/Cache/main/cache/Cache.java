package Cache.main.cache;

import Cache.main.cache.exceptions.NotFoundException;
import Cache.main.cache.exceptions.StorageFullException;
import Cache.main.cache.policies.EvictionPolicy;
import Cache.main.cache.storage.Storage;

public class Cache<Key, Value> {

    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value) {
        try {
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Storage is full. Will try to Evict .......");
            Key keyToRemove = evictionPolicy.evict();

            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }

            storage.remove(keyToRemove);
            System.out.println("Evicted key: " + keyToRemove);
            put(key, value);
        }

    }

    public Value get(Key key) {
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException exception) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }

}
