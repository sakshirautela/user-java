import java.util.ArrayList;

public class LiftRunning extends Thread {
    private ArrayList<Integer> src=new ArrayList<Integer>();
    private ArrayList<Integer> dest=new ArrayList<Integer>();

    public LiftRunning(int s, int d) {
        src.add(s);
        dest.add(d);
    }

    @Override
    public void run() {
        System.out.println("Lift reached floor " + src);

        // if (src < dest) {
        //     for (int i = src + 1; i <= dest; i++) {
        //         floor(i);
        //     }
        // } else {
        //     for (int i = src - 1; i >= dest; i--) {
        //         floor(i);
        //     }
        // }

        System.out.println("Lift reached floor " + dest);
    }

    @SuppressWarnings("unused")
    private void floor(int floor) {
        try {
            Thread.sleep(3000); 
            System.out.println( floor);
        } catch (InterruptedException e) {
            System.out.println("Lift interrupted.");
        }
    }
}
