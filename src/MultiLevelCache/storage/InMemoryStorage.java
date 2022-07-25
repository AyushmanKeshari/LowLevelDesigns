package MultiLevelCache.storage;

import MultiLevelCache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage<Key, Value> implements Storage<Key, Value> {

    private final Map<Key, Value> storage;
    private final int capacity;

    public InMemoryStorage(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) {
            throw new StorageFullException();
        }
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) {
        storage.remove(key);
    }

    @Override
    public Value get(Key key) {
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
