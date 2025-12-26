import java.util.HashMap;
import java.util.PriorityQueue;

public class MinDeletion {
    public static void main(String[] args) {
        System.out.println(minCost("aabaac",new int[]{1,2,3,4,1,10}));
    }
        public static long minCost(String s, int[] cost) {
            char[] ch=s.toCharArray();
            PriorityQueue<Long>pq=new PriorityQueue<>();
            HashMap<Character,Long> freq=new HashMap<>();
            for(int i=0;i<s.length();i++) {
                char c=s.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0l) + cost[i]);
            }
            System.out.println(freq);
            if(freq.size()==1){
                return 0;
            }
            pq.addAll(freq.values());
            long result=0;
            while (!pq.isEmpty()&& pq.size()>1){
                result+=pq.remove();
            }
            return result;
        }
}
