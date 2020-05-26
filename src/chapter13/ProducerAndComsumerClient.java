package chapter13;

/**
 * @Auther lujieni
 * @Date 2020/5/26
 */
public class ProducerAndComsumerClient {

    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();

        new ProducerThread(messageQueue,1).start();
        new ProducerThread(messageQueue,2).start();
        new ProducerThread(messageQueue,3).start();


        new ConsumerThread(messageQueue,1).start();
        new ConsumerThread(messageQueue,2).start();


    }
}
