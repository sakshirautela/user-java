package MessageBrokers_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueueImp {
    private final Queue<String> queue=new LinkedList<String>();
    private final Lock lock=new ReentrantLock();
    private final Condition notEmpty=lock.newCondition();
    public void sendMessage(String message){
        lock.lock();
        try {
            queue.add(message);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
public String receiveMessage(){
        lock.lock();
        try{
            while(queue.isEmpty()){
                try{
                    notEmpty.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }finally {
            lock.unlock();
        }
}
}
class Producer implements Runnable{
    private final MessageQueueImp messageQueueImp;
    private final int id;
    private final String message;
    public Producer(MessageQueueImp messageQueueImp,int id,String message){
        this.messageQueueImp=messageQueueImp;
        this.id=id;
        this.message=message;
    }

    @Override
    public void run() {
        System.out.println("Producer "+id+" "+"sending: "+message);
    }
}
class Consumer implements Runnable{
    private final MessageQueueImp messageQueueImp;
    public Consumer(MessageQueueImp messageQueueImp){
        this.messageQueueImp=messageQueueImp;
    }
    @Override
    public void run() {
        System.out.println("Received message: "+messageQueueImp.receiveMessage());
    }
}
