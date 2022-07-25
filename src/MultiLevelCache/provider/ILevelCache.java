package MultiLevelCache.provider;

import MultiLevelCache.model.ReadResponse;
import MultiLevelCache.model.WriteResponse;

import java.util.List;

public interface ILevelCache<Key, Value> {

    WriteResponse set(Key key, Value value);

    ReadResponse<Value> get(Key key);

    List<Double> getUsages();

}
