package Contest;

import java.util.Arrays;

public class WeeklyContest520 {
    static void main() {
        //System.out.println(countIntersectingIntervals(new int[][]{}));
        System.out.println(countIntersectingIntervalsII(new int[][]{{1,2},{2,3},{3,4}}));
    }
    public static int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int n=intervals.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(intervals[i][1]>=intervals[j][0] ){
                    count++;
                }
            }
        }
        return count;
    }
    public static long countIntersectingIntervalsII(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int n=intervals.length;
        long count=0;
        for(int i=0;i<n-1;i++){
           long r=BinarySearch(intervals,i,n-1,intervals[i][1]);
           count+=r-i;
        }
        return count;
    }
    public static long BinarySearch(int[][] intervals,int i,int j,int target) {
        if(i==j){
            return 0;
        }
        while (i<=j){
            int mid=(i+j)/2;
            if(target<=intervals[mid][0]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
}
