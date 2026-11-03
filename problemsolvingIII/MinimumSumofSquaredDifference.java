package problemsolvingIII;

import java.util.*;

public class MinimumSumofSquaredDifference {
    static void main() {
        System.out.println(minSumSquareDiff(new int[]{1,4,10,12},new int[]{5,8,6,9},1,1));
    }
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k=k1+k2;
        for(int i = 0; i < n; i++){
            nums1[i]=(Math.abs(nums1[i]-nums2[i]));
        }

        Arrays.sort(nums1);

        for(int i=n-1;i>=1;i--){
            if(k<=0){
                break;
            }
            if(nums1[i]-nums1[i-1]>=2){
                k-=2;
                nums1[i]-=2;
            }else{
                nums1[i]-=1;
                k--;
            }
            if(k<=0){
                break;
            }
        }
        long ans=0;
        for(int i:nums1){
ans+=((long) i *i);
        }
        return ans;
    }
}
