package problemsolvingIII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MaximumElementAfterDecreasingandRearranging {
    static void main() {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
        }
        return arr[n-1];
    }
}
