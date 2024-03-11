import java.util.Arrays;
import java.util.*;

class MinOperationsToContinuesArray {
    public static int minOperations(int[] nums) {
        // int N = nums.length;
        // int ans = N;
        // int j = 0;

        // // Sort the array
        // Arrays.sort(nums);

        // // Remove duplicates to only keep unique elements
        // int M = 1;
        // for (int i = 1; i < N; ++i) {
        //     if (nums[i] != nums[i - 1]) {
        //         nums[M] = nums[i];
        //         M++;
        //     }
        // }

        // for (int i = 0; i < M; ++i) {
        //     while (j < M && nums[j] < nums[i] + N) {
        //         ++j;
        //     }

        //     // The length of this subarray is `j - i`. We need to replace `N - j + i`
        //     // elements to make it continuous.
        //     ans = Math.min(ans, N - j + i);
        // }

        // return ans;
        int res=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int j=1;
        int dp=0;
        int[] dup=new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while(j<nums.length && nums[j]<=nums[i]+nums.length-1){
                if(nums[j]==nums[j-1]) ++dp;
                dup[j] =dp;
                j++;
            }
            res=Math.min(res,i+nums.length-j+dp-dup[i]);

        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(minOperations(new int[]{1,2,3,4}));
    }
}

