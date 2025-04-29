
import java.util.*;
public class perfectMeetingGfg {
    public static int firsthour(int n, int[][] arr) {
        // code here
        Arrays.sort(arr);
        int min=arr[0][0];
        int max=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]>=arr[i-1][1]){
                min=Math.max(arr[i][0],min);
                max=Math.min(arr[i][1],max);
            }else{
                return 0;
            }
        }
        return max-min;

    }
    public static void main(String agrs[]){
        System.out.println(firsthour(0,new int[][]{{}}));
    }
}
