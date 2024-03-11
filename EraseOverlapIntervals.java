import java.util.*;
public class EraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int prev=intervals[0][1];
        int ans=0;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        for(int i=1;i<intervals.length;i++) {
            if(prev>intervals[i][0]){
                ans++;
            }else{
                prev=intervals[i][1];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{1,3},{2,3},{3,4}}));
    }
}