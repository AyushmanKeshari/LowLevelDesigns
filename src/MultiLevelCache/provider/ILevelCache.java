package MultiLevelCache.provider;

import MultiLevelCache.model.ReadResponse;
import MultiLevelCache.model.WriteResponse;

public interface ILevelCache<Key, Value> {

    WriteResponse set(Key key, Value value);

    ReadResponse<Value> get(Key key);

}
