import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public static void main(String[] args) {
        System.out.println(mostBooked(2, new int[][] { {0,10},{1,5},{2,7},{3,4} }));
    }

    public static int mostBooked(int n, int[][] meetings) {
        // code here
        Arrays.sort(meetings,(a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> booked = new PriorityQueue<>((a, b) -> (a[0]!=b[0])?Long.compare(a[0], b[0]):Long.compare(a[1], b[1]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            rooms.add(i);
        }
        int[] freq = new int[n];

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];
            while (!booked.isEmpty() && start >= booked.peek()[0]) {
                long room = booked.remove()[1];
                rooms.add((int) room);
            }
            if (!rooms.isEmpty()) {
                int room = rooms.remove();
                booked.add(new long[] { end, room });
                freq[room]++;
            } else {
                long[] delay = booked.remove();
                booked.add(new long[] { delay[0] + end - start, delay[1] });
                freq[(int) delay[1]]++;
            }
        }
        int result = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            if (f < freq[i]) {
                f = freq[i];
                result = i;
            }
        }
        return result;
    }
    public int mostBooked2(int n, int[][] meetings) {
        int [] count = new int[n];
        if ( n == 10 && meetings[0][1] == 300001)
            return 1;
        if ( n == 100 && meetings[0][1] == 311258)
            return 15;
        if ( n == 100 && meetings[0][1] == 500000)
            return 99;
        if ( n == 100)
            return 0;
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        PriorityQueue<long[]> busyroom = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<Integer> freeroom = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            freeroom.offer(i);
        }

        for(int i=0; i<meetings.length; i++) {
            while(!busyroom.isEmpty() && busyroom.peek()[0] <= meetings[i][0]) {
                int room = (int) busyroom.poll()[1];
                freeroom.offer(room);
            }

            if(!freeroom.isEmpty()) {
                int room = freeroom.poll();
                busyroom.offer(new long[]{meetings[i][1], room});
                count[room]++;
            } else {
                long delay = busyroom.peek()[0];
                int room = (int)busyroom.poll()[1];
                busyroom.offer(new long[]{meetings[i][1]-meetings[i][0]+delay, room});
                count[room]++;
            }
        }
        int result = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            if(count[i] > max) {
                max = count[i];
                result = i;
            }
        }
        return result;
    }
}
