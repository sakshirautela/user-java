import java.util.PriorityQueue;

public class MinimumNumberofSecondstoMakeMountainHeightZero {
    static void main() {
        System.out.println(minNumberOfSeconds(4, new int[]{2,1,1}));
    }

    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int time = 0;
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{workerTimes[i], i,1});
        }
        while (mountainHeight > 0) {
            int[] poll = pq.poll();
            int prev = poll[0];
            int k=poll[2]+1;
            int next=workerTimes[poll[1]]*((k*(k+1))/2);
            time=Math.max(time,prev);
            pq.add(new int[]{next, poll[1],k});
            mountainHeight--;
        }
        return time;
    }
}
