package MessageQueue.PubSubQueue.publicInterface;

import MessageQueue.PubSubQueue.model.Message;

public interface ISubscriber {
    String getId();

    void consume(Message message) throws InterruptedException;
}
