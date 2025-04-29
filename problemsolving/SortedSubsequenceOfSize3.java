
import java.util.*;
public class SortedSubsequenceOfSize3 {
    public static List<Integer> find3Numbers(int[] arr) {
        // code here
        int n=arr.length;
        int[] leftMin=new int[n];
        int[] rightMax=new int[n];
        leftMin[0]=Integer.MAX_VALUE;
        rightMax[n-1]=Integer.MIN_VALUE;
        List<Integer> al=new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            leftMin[i]=Math.min(arr[i-1],leftMin[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(arr[i+1],rightMax[i+1]);
        }
        for(int i=1; i<n-1; i++){
            if(leftMin[i] < arr[i] && arr[i] < rightMax[i]){
                al.add(leftMin[i]);
                al.add(arr[i]);
                al.add(rightMax[i]);
                break;
            }
        }
        return al;
    }
    public static void main(String agrs[]){
        System.out.println(find3Numbers(new int[]{104, 753 ,852 ,120 ,676 ,984}));
    }
}
