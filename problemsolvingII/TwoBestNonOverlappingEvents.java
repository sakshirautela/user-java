import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        System.out.println(maxTwoEvents(new int[][]{{}}));
    }
    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int max=0;
        int value=0;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()&& pq.peek()[1]<events[i][0]) {
                max=Math.max(max,pq.poll()[2]);
            }
            value=Math.max((max+events[i][2]),value);
            pq.add(new int[]{events[i][0],events[i][1],events[i][2]});
        }
        return value;
    }
    public int maxTwoEventsFast(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = Math.max(f[i + 1], events[i][2]);
        }
        int ans = 0;
        for (int[] e : events) {
            int v = e[2];
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (events[mid][0] > e[1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left < n) {
                v += f[left];
            }
            ans = Math.max(ans, v);
        }
        return ans;
    }
}