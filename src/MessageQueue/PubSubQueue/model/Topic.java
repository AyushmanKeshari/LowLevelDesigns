package MessageQueue.PubSubQueue.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private final String topicName;
    private final String topicId;
    private final List<Message> messageList;

    private final List<TopicSubscriber> subscribers;

    public Topic(@NonNull final String topicName, @NonNull final String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messageList = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public synchronized void addMessage(@NonNull final Message message) {
        messageList.add(message);
    }

    public void addSubscriber(@NonNull final TopicSubscriber topicSubscriber) {
        subscribers.add(topicSubscriber);
    }
}
