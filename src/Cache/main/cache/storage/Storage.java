package Cache.main.cache.storage;

import Cache.main.cache.exceptions.NotFoundException;
import Cache.main.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {

    void put(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws NotFoundException;

    void remove(Key key) throws NotFoundException;

}
