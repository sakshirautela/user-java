import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PowerfulInteger {
    public static void main(String[] args) {
        System.out.println(powerfulInteger(new int[][]{{1 ,3},{3, 6},{3, 4}}, 2));
    }

    public static int powerfulInteger(int[][] intervals, int k) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Mark interval start and
        // end+1 with +1 and -1 respectively
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int ans = -1;
        int temp = 0;
        // Traverse the map (sorted keys) and
        // track frequency using prefix sum
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int delta = entry.getValue();

            if (delta >= 0) {
                temp += delta;
                if (temp >= k) {
                    ans = point;
                }
            } else {
                if (temp >= k) {
                    ans = point - 1;
                }
                temp += delta;
            }
        }

        return ans;
    }
}
/*public class GfG {

    public static int powerfulInteger(int[][] intervals, int k) {
        int ma = intervals[0][1];
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            ma = Math.max(ma, intervals[i][1]);
        }

        int[] count = new int[ma + 1];

        // Count occurrences of each
        // integer in the intervals
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j <= end; j++) {
                count[j]++;
            }
        }

        int ans = -1;

        // Find the maximum integer
        // with frequency >= k
        for (int i = 1; i <= ma; i++) {
            if (count[i] >= k) {
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {4, 6},
            {3, 4}
        };

        int k = 2;

        int result = powerfulInteger(intervals, k);
        System.out.println(result);
    }
}*/
