import java.util.HashMap;
import java.util.PriorityQueue;

public class GamewithString {
    public static void main(String[] args) {
        System.out.println(minValue("aabbbbccc",3));
    }
    public static int minValue(String s, int k) {
        // code here
        HashMap<Character,Integer> freq=new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch,freq.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for (char ch : freq.keySet()) {
            pq.add(freq.get(ch));
        }
        while (k>0 && !pq.isEmpty()) {
            int f=pq.remove();
            f--;
            k--;
            if(f>0){
                pq.add(f);
            }
        }
        int result=0;
        while (!pq.isEmpty()) {
            int f=pq.remove();
            result+=f*f;
        }
        return result;
    }
}