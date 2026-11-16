package problemsolvingIII;

import java.util.Arrays;

public class FindtheDistanceValueBetweenTwoArrays {
    static void main() {
        System.out.println(findTheDistanceValue(new int[]{4,5,8},new int[]{10,9,1,8},2));
    }
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n=arr1.length;
        int m=arr2.length;
        int res=0;
        for(int i=0;i<n;i++){
            if(!isUnderRange(d,arr2,arr1[i],m)){
                res++;
            }
        }
        return res;
    }

    private static boolean isUnderRange(int d, int[] arr2, int el, int m) {
        int i=0,j=m-1;
        while (i<=j){
            int mid=(i+j)/2;
            if(Math.abs(el-arr2[mid])<=d){
                return true;
            }
            if(el>arr2[mid]){
                    i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return false;
    }
}
