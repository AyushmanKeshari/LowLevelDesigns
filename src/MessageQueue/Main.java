package MessageQueue;

import MessageQueue.PubSubQueue.SleepingSubscriber;
import MessageQueue.PubSubQueue.model.Message;
import MessageQueue.PubSubQueue.model.Topic;
import MessageQueue.PubSubQueue.publicInterface.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Queue queue = new Queue();
        final Topic topic1 = queue.createTopic("t1");
        final Topic topic2 = queue.createTopic("t2");
        final SleepingSubscriber sub1 = new SleepingSubscriber("sub1", 10000);
        final SleepingSubscriber sub2 = new SleepingSubscriber("sub2", 10000);
        queue.subscribe(sub1, topic1);
        queue.subscribe(sub2, topic1);

        final SleepingSubscriber sub3 = new SleepingSubscriber("sub3", 5000);
        queue.subscribe(sub3, topic2);

        queue.publish(topic1, new Message("m1"));   //s1, s2
        queue.publish(topic1, new Message("m2"));   //s1, s2

        queue.publish(topic2, new Message("m3"));   //s3

        Thread.sleep(15000);
        queue.publish(topic2, new Message("m4"));   //s3
        queue.publish(topic1, new Message("m5"));   //s1, s2

        queue.resetOffset(topic1, sub1, 0);
    }
}
