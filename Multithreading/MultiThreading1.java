public class MultiThreading1 {
    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());
        //Thread thread =new Thread -> this is when we will run Thread class not runnanble
        Thread1 t1=new Thread1(); //
        Thread thread=new Thread(t1);
        thread.start();
        for(;;){
            System.out.println("Hello " +Thread.currentThread().getName());
        }
    }
}