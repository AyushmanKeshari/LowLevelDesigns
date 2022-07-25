package MultiLevelCache.service;

import MultiLevelCache.model.ReadResponse;
import MultiLevelCache.model.StatResponse;
import MultiLevelCache.model.WriteResponse;
import MultiLevelCache.provider.ILevelCache;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;


public class CacheService<Key, Value> {
    private final ILevelCache<Key, Value> multiLevelCache;
    private final List<Double> lastReadTimes;
    private final List<Double> lastWriteTimes;
    private final int lastCount;

    public CacheService(@NonNull final ILevelCache<Key, Value> multiLevelCache, int lastCount) {
        this.multiLevelCache = multiLevelCache;
        this.lastCount = lastCount;
        this.lastReadTimes = new ArrayList<>();
        this.lastWriteTimes = new ArrayList<>();
    }

    public WriteResponse set(@NonNull final Key key, @NonNull final Value value) {
        final WriteResponse writeResponse = multiLevelCache.set(key, value);
        addTimes(lastWriteTimes, writeResponse.getTimeTaken());
        return writeResponse;
    }

    public ReadResponse<Value> get(@NonNull final Key key) {
        final ReadResponse<Value> readResponse = multiLevelCache.get(key);
        addTimes(lastReadTimes, readResponse.getTotalTime());
        return readResponse;
    }

    public StatResponse stats() {
        return new StatResponse(getAvgReadTime(), getAvgWriteTime(), multiLevelCache.getUsages());
    }

    private void addTimes(List<Double> times, Double time) {
        if (times.size() == this.lastCount) {
            times.remove(0);
        }

        times.add(time);
    }

    private Double getAvgReadTime() {
        return getSum(lastReadTimes) / lastReadTimes.size();
    }

    private Double getAvgWriteTime() {
        return getSum(lastWriteTimes) / lastWriteTimes.size();
    }

    private Double getSum(List<Double> times) {
        Double sum = 0.0;
        for (Double time : times) {
            sum += time;
        }
        return sum;
    }

}
