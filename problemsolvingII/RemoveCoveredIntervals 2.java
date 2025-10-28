import java.util.ArrayList;
import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {1, 2}, {3, 4}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->(a[0]==b[0])?a[1]-b[1]: a[0] - b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            if (!(result.getLast()[1] >= intervals[i][1] && result.getLast()[0] <= intervals[i][0])) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if ((result.getLast()[0] >= intervals[i][0] && result.getLast()[1] <= intervals[i][1])) {
                result.removeLast();
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        for (int[] i : result) {
            System.out.println(i[0] + " " + i[1]);
        }
        return result.size();
    }
}