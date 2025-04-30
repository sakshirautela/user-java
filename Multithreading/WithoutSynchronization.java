class Counter{
    private int counter=0;
    public  void increment(){
        counter++;
    }
    public  int getCount(){
        return counter;
    }
}
public class WithoutSynchronization extends Thread{
    private Counter count;
    public WithoutSynchronization(Counter counter){
        this.count=counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            count.increment();
        }
    }
    public static void main(String[] args) {
        Counter count=new Counter();
        WithoutSynchronization thread1=new WithoutSynchronization(count);
        WithoutSynchronization thread2=new WithoutSynchronization(count);
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