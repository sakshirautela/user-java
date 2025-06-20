import java.util.Arrays;

public class MaximumNumberofEventsThatCanBeAttended {
    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][] { {1,4},{4,4},{2,2},{3,4},{1,1}}));
    }

    public static int maxEvents(int[][] events) {
        int n = events.length;
        int result = 0;
        Arrays.sort(events, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int end = events[i][1];
            int diff = end - start;
            result++;
            int idx=i+1;
            while (idx<n && start==events[idx][0] && end==events[idx][1]) {
                if(diff>0){
                    diff--;
                }
                idx++;
            }
        }
        return result;
    }
}