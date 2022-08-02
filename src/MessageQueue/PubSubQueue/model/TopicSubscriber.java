package MessageQueue.PubSubQueue.model;

import MessageQueue.PubSubQueue.publicInterface.ISubscriber;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    private final AtomicInteger offset;     //Allows to handle multi-threading.
    private final ISubscriber subscriber;

    public TopicSubscriber(@NonNull final ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }
}
