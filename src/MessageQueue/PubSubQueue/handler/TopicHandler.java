package MessageQueue.PubSubQueue.handler;

import MessageQueue.PubSubQueue.model.Topic;
import MessageQueue.PubSubQueue.model.TopicSubscriber;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers;


    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

    public void startSubscriberWorker(@NonNull final TopicSubscriber topicSubscriber) {
        final String subscriberID = topicSubscriber.getSubscriber().getId();

        if (!subscriberWorkers.containsKey(subscriberID)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberID, subscriberWorker);

            new Thread(subscriberWorker).start();
        }

        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberID);
        subscriberWorker.wakeUpIfNeeded();
    }
}
