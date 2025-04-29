
import java.util.*;

public class MaximizeFreeTime {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        
        // Calculate gaps between meetings
        gaps[0] = startTime[0]; // Gap before the first meeting
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1]; // Gap after the last meeting
        
        // Sort gaps to find the k largest ones to modify
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i < n; i++) { // We don't modify first and last gaps
            minHeap.offer(gaps[i]);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest gap from the k largest ones
            }
        }
        
        // Add the remaining largest gaps to maximize free time
        int maxFreeTime = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!minHeap.isEmpty() && minHeap.contains(gaps[i])) {
                minHeap.remove(gaps[i]);
            } else {
                maxFreeTime = Math.max(maxFreeTime, gaps[i]);
            }
        }
        
        return maxFreeTime;
    }

    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5})); // Expected: 2
        System.out.println(maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10})); // Expected: 6
        System.out.println(maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})); // Expected: 0
    }
}
