import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr={ 10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=-1;
        for (int i = 0; i < dp.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static int longestIncreasigSubsequence(int[] arr){
        HashSet<Integer> set=new HashSet();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int copy[]=new int[set.size()];
        int i=0;
        for(int num:set){
            copy[i]=num;
            i++;
        }
        Arrays.sort(copy);
        for(int j=0;j<copy.length; j++){  
            System.out.print(copy[j]+" ");
        }
        return helper(arr,copy,arr.length,copy.length);
    }
    private static int helper(int[] arr, int[] copy, int n, int m) {
        int dp[][]=new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==copy[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        printdp(dp);
        return dp[n][m];
    }

    private static void printdp(int[][] dp) {
        for(int i=1;i< dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
