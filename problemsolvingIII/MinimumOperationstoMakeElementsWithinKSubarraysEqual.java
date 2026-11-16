package problemsolvingIII;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumOperationstoMakeElementsWithinKSubarraysEqual {
    static void main() {
        System.out.println(minOperations(new int[]{},4,3));
    }
    class Operation {
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int leftSize = 0;
        int rightSize = 0;
        int leftS=0;
        int rightS=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        void removeEl(PriorityQueue<Integer> pq) {
            while(!pq.isEmpty() && map.getOrDefault(pq.peek(),0)>0){
                int a=pq.poll();
                map.put(a,map.get(a)-1);
            }
        }
        void add(int a){
            if(leftSize>rightSize+1){
                int b=left.poll();
                right.add(b);
                leftS+=b;
                rightS-=b;
                rightSize++;
                leftSize--;
            }else{

            }
        }
    }
    public static long minOperations(int[] nums, int x, int k) {
return 0l;
    }
}
