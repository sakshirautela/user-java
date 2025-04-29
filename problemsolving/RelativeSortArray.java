
import java.util.Arrays;
import java.util.HashMap;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxEl=Integer.MIN_VALUE;
        for (int i : arr1) {
            maxEl=Math.max(maxEl,i);
        }
        int[] count=new int[maxEl+1];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        int[] result=new int[arr1.length];
        int idx=0;
        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]]>0) {
                result[idx]=arr2[i];
                count[arr2[i]]--;
                idx++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0) {
                result[idx]=i;
                count[i]--;
                idx++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] result=relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6});
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
