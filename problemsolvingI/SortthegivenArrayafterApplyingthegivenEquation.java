import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortthegivenArrayafterApplyingthegivenEquation {
    public static void main(String[] args) {
        System.out.println(sortArray(new int[]{},2,3,4));
    }
    public static ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        ArrayList<Integer> al=new ArrayList<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int val : arr) {
            pq.add(A*(val*val)+B*val+C);            
        }
        while (!pq.isEmpty()) {
            al.add(pq.remove());
        }
        return al;
    }
}