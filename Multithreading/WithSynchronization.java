class Counter2{
    private int counter=0;
    public synchronized  void increment(){ //one thread entry at one time
        counter++;
    }
    public  int getCount(){
        return counter;
    }
}
public class WithSynchronization extends Thread{
    private Counter2 count;
    public WithSynchronization(Counter2 counter){
        this.count=counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            count.increment();
        }
    }
    public static void main(String[] args) {
        Counter2 count=new Counter2();
        WithSynchronization thread1=new WithSynchronization(count);
        WithSynchronization thread2=new WithSynchronization(count);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(count.getCount());
    }
}