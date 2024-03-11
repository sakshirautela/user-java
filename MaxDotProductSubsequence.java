import java.util.Arrays;

class MaxDotProductSubsequence {
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int d[][]=new int[nums1.length+1][nums2.length+1];
        for (int i=0; i<nums1.length+1; i++){
            Arrays.fill(d[i],-1);
        }
        return solve(nums1, nums2,0,0,d);
        
    }
    private static int solve(int[] nums1, int[] nums2, int i, int j, int[][] d) {
        if(i==nums1.length || j==nums2.length){
            return 0;//Integer.MIN_VALUE-5;
        }
        if(d[i][j]!=-1){
            return d[i][j];
        }
        int a=nums1[i]*nums2[j];
        int c=(nums1[i]*nums2[j])+solve(nums1,nums2,i+1,j+1,d);
        int n=solve(nums1,nums2,i,j+1,d);
        int b=solve(nums1,nums2,i+1,j,d);        
        return d[i][j]=Math.max(a,Math.max(c,Math.max(b,n)));

        // int m = nums2.length + 1;
        // int[] dp = new int[m];
        // int[] prevDp = new int[m];
        
        // for (int i = nums1.length - 1; i >= 0; i--) {
        //     dp = new int[m];
        //     for (int j = nums2.length - 1; j >= 0; j--) {
        //         int use = nums1[i] * nums2[j] + prevDp[j + 1];
        //         dp[j] = Math.max(use, Math.max(prevDp[j], dp[j + 1]));
        //     }
            
        //     prevDp = dp;
        // }
        
        // return dp[0];
    }
    public static void main(String[] args){
        System.out.println(maxDotProduct(new int[]{2,1,-2,5},new int[]{3,0,-6}));
    }
}