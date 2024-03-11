import java.util.*;

public class FindLeastNumOfUniqueInts {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> hm=new TreeMap<Integer, Integer>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        for(int i:hm.keySet()) {
            q.add(hm.get(i));
        }
        while (!q.isEmpty() && k>0) {
            if(k>=q.peek()){
                k-=q.remove();
            }
            else{
                k=0;
            }

        }
        System.out.println(q);
        return q.size();
    }
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3));
    }
}