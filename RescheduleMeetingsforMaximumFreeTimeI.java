import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RescheduleMeetingsforMaximumFreeTimeI {
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, 4, new int[] {}, new int[] {}));
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        // Calculate the free time gaps
        List<Integer> gaps = new ArrayList<>();
        gaps.add(startTime[0]); 
        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i - 1]); 
        }
        gaps.add(eventTime - endTime[n - 1]); 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gap : gaps) {
            maxHeap.add(gap);
        }

        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            int largestGap = maxHeap.poll();
            if (maxHeap.isEmpty()) break;
            int secondLargestGap = maxHeap.poll();
            maxHeap.add(largestGap + secondLargestGap); 
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
