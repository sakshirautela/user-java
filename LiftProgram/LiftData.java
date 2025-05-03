package LiftProgram;
import java.util.ArrayList;
import java.util.Queue;

public record LiftData() {
    static int dest; // destination floor
    static int src; // base floor 
    static boolean state; // true-running ,false - rest
    static int dir; // 1-running up ,0 - down
    static ArrayList<Integer> up;
    static ArrayList<Integer> down;
    static Queue<int[]> priority;
    LiftData(int dir,int src,int dest){
        this();
        this.dir=dir;
        this.src=src;
        this.dest=dest;
        this.priority.add(new int[]{src,dest,dir});
        if(dir==1){
            up.add(src);
            up.add(dest);
        }else{
            down.add(src);
            down.add(dest);
        }
    }
} 
