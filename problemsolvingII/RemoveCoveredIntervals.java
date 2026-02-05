import java.util.ArrayList;
import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {1, 2}, {3, 4}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]!=b[0])?Integer.compare(a[0], b[0]):Integer.compare(b[1],a[1]));
        int result=0;
        int start=intervals[0][0];
        int end=intervals[0][1];
        int n=intervals.length;
        for (int i = 1; i < n; i++) {
            if(end>=intervals[i][1]&& start<=intervals[i][0]){
                result++;
            }else{
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        return n-result;
    }
}