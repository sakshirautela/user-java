import java.util.HashMap;

public class LargestConsecutiveSequenceGFG {
    public int longestConsecutive(int[] arr) {
        int maxSize = Integer.MIN_VALUE;
        int size = 0;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        
        HashMap<Integer, Integer> hp = new HashMap<>();
        
        for(int num : arr) {
            hp.put(num, 0);
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }
        
        for(int i=smallest; i<=largest; i++) {
            if(hp.containsKey(i)) size++;
            else size = 0;

            maxSize = Math.max(size, maxSize);
        }
        
        return maxSize;
    }
}
