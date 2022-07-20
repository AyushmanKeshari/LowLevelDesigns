package Cache.main.cache.storage;

import Cache.main.cache.exceptions.NotFoundException;
import Cache.main.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    private Map<Key, Value> storage;
    private int capacity;

    public HashMapBasedStorage(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if (isFull()) {
            throw new StorageFullException("Capacity full ....");
        }
        storage.put(key, value);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) {
            throw new NotFoundException(key + " not found in cache.......");
        }
        return storage.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) {
            throw new NotFoundException(key + " not found in cache.......");
        }
        storage.remove(key);
    }

    private boolean isFull() {
        return storage.size() == capacity;
    }
}
