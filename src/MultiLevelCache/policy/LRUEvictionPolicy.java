package MultiLevelCache.policy;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    @Override
    public void keyAccessed(Key key) {
        //TODO: Implement - Refer to single level Cache.
    }

    @Override
    public Key evict() {
        //TODO: Implement - Refer to single level Cache.
        return null;
    }
}
