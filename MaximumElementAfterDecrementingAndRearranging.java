import java.util.*;
public class MaximumElementAfterDecrementingAndRearranging {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1;
        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i]-arr[i-1])>1){
                arr[i]=arr[i-1]+1;
            }
        }
        return arr[n-1];        
    }
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
    }
}