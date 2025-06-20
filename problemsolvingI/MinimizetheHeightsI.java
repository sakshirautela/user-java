
import java.util.*;
public class MinimizetheHeightsI {
    static int minimzeHeight(int n,int k,int[] arr){
        Arrays.sort(arr);
        int min=arr[0],max=arr[n-1];
        int res=max-min;
        for (int i = 1; i < arr.length; i++) {
            min=Math.min(arr[i]-k,arr[0]+k);
            max=Math.max(arr[i-1]+k,arr[n-1]-k);
            res=Math.min(res, max-min);
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(minimzeHeight(5, 2,new int[]{2,3,4,5,7}));
    }
}
