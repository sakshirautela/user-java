package MessageBrokers_Queue;

public class MainMessageImp {
    static void main() {
        MessageQueueImp messageQueue=new MessageQueueImp();
        Thread producerThread=new Thread(new Producer(messageQueue,1,"Hello World"));
        Thread consumerThread = new Thread(new Consumer(messageQueue));
        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
