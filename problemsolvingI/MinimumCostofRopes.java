
import java.util.*;
public class MinimumCostofRopes {
    // Function to return the minimum cost of connecting the ropes.
    public static long minCost(long[] arr) {
        // code here'
        long res=0;
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while(!pq.isEmpty() && pq.size()>=2){
            long a=pq.remove();
            long b=pq.remove();
            pq.add(a+b);
            res+=a+b;
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(minCost(new long[]{4, 2, 7, 6, 9}));
    }
}
