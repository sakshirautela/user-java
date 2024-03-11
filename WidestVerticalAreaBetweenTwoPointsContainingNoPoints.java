import java.util.*;
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b)-> a[0]-b[0]);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<points.length-1;i++){
            ans=Math.max(ans,(points[i+1][0]-points[i][0]));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][]{{8,7},{9,9},{7,4},{9,7}}));
    }
}