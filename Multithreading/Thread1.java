//import java.lang.Thread; <-by default get importated parent package
public class Thread1 implements Runnable{//extends Thread {
    // @Override
    // public void run() {
    //     for(;;){
    //         System.out.println("Hello " + Thread.currentThread().getName());
    //     }
    // }
    
    @Override
    public void run() {
        for(;;){
                    System.out.println("Hello " + Thread.currentThread().getName());
                }
    }
}