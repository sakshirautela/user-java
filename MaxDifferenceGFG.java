import java.util.*;
public class MaxDifferenceGFG {
    public static long fndMax(int n, int m, int[] arr1, int[] arr2) {
        // code here
        Arrays.sort(arr1);
        long res=0;
        int idx=0;
        boolean[] isTaken=new boolean[m];
        for(int i=0;i<n;i++){
            int diff=0;
            for(int j=0;j<m;j++){
                if(!isTaken[j] && diff<Math.abs(arr1[i]-arr2[j])){
                    diff=Math.abs(arr1[i]-arr2[j]);
                    idx=j;
                }
            }
            res+=diff;
            isTaken[idx]=true;
        }
        return res;
    }
    public static void main(String agrs[]){
        System.out.println(fndMax(3,5,new int[]{6,3,2},new int[]{11,3,9,7,2}));
    }
}