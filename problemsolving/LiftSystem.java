
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

public class LiftSystem {
    static int levels[] = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    static int dir = 0;

    static class LiftProperties {
        int dir;
        int currfloor;
        PriorityQueue<Integer> up;
        PriorityQueue<Integer> down;

        public LiftProperties() {
            dir = 0;// show initial state 1 for running 2 for ideal
            currfloor = 10;// show rest ,1 for up and 2 for down
            up = new PriorityQueue<>();
            down = new PriorityQueue<>(Collections.reverseOrder());
        }
    }

    static class UserProperties {
        int src;
        int dest;
        int dir;

        public UserProperties(int src, int dest) {
            this.src = src;
            this.dest = dest;
            this.dir = (src<dest) ? 1 : 2;
        }
    }

    static Queue<UserProperties> waiting = new LinkedList<>();

    static LiftProperties lift = new LiftProperties();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your destination");
        int dest = sc.nextInt();
        System.out.println("enter your source");

        int src = sc.nextInt();
        System.out.println(dest + " " + src );
        UserProperties user = new UserProperties(src, dest);
        addUser(user);
        startLift();
    }

    private static void startLift() {
        if(lift.dir==1 && !lift.up.isEmpty()){
            moveUp();
        }else if(lift.dir==2 && !lift.down.isEmpty()){
            moveDown();
        }else{
            if(!lift.up.isEmpty()){
                lift.dir=1;
            }else if (!lift.down.isEmpty()){
                lift.dir=2;
            }else{
                addPendingReq();
            }
        }
    }

    private static void moveUp() {
        while(!lift.up.isEmpty() && lift.currfloor<=lift.up.peek()){
            if(lift.up.peek()==lift.currfloor){
                lift.up.poll();
                System.out.println("lift open at " +lift.currfloor);
                while (!lift.up.isEmpty() && lift.up.peek()==lift.currfloor) {
                    lift.up.remove();
                }
                System.out.println("lift close");
            }else{
                System.out.println("lift at " +lift.currfloor);
            }

            if(lift.currfloor>10){
                break;
            }else{
                lift.currfloor++;
            }
        }
        if(lift.up.isEmpty() || lift.currfloor>10){
            if(!lift.down.isEmpty()){
                lift.dir=2;
            }else{
                lift.dir=0;
                addPendingReq();
            }
        }
    }

    private static void moveDown() {
        while(!lift.down.isEmpty() && lift.currfloor>=lift.down.peek()){
            if(lift.down.peek()==lift.currfloor){
                lift.down.poll();
                System.out.println("lift open at " +lift.currfloor);
                while (!lift.down.isEmpty() && lift.down.peek()==lift.currfloor) {
                    lift.down.remove();
                }
                System.out.println("lift close");
            }else{
                System.out.println("lift at " +lift.currfloor);
            }

            if(lift.currfloor<0){
                break;
            }else{
                lift.currfloor--;
            }
        }
        if(lift.down.isEmpty() || lift.currfloor<0){
            if(!lift.up.isEmpty()){
                lift.dir=1;
            }else{
                lift.dir=0;
                addPendingReq();
            }
        }
    }

    private static void addPendingReq() {
        while (!waiting.isEmpty()) {
            addUser(waiting.poll());
        }
    }

    private static void addUser(UserProperties user) {
        if (user.dir == 1) {
            if (lift.dir == 0) {
                lift.up.add(user.src);
                lift.up.add(user.dest);
                lift.dir = 1;
            } else if(lift.dir==1){
                if (lift.currfloor < user.src) {
                    lift.up.add(user.src);
                    lift.up.add(user.dest);
                } else {
                    waiting.add(user);
                }
            }else{
                waiting.add(user);
            }
        } else {
            if (lift.dir == 0) {
                lift.down.add(user.src);
                lift.down.add(user.dest);
                lift.dir = 2;
            } else if(lift.dir==2){
                if (lift.currfloor > user.src) {
                    lift.down.add(user.src);
                    lift.down.add(user.dest);
                } else {
                    waiting.add(user);
                }
            }else{
                waiting.add(user);
            }
        }
    }
}
