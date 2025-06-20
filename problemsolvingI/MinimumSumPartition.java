import java.util.Arrays;

public class MinimumSumPartition {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[] { 1, 6, 11, 5 }));
    }

    public static int minDifferenceDP(int arr[]) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        
        int n = arr.length;
        int[][] dp = new int[n+1][totalSum + 1];
         for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        for(int i=n;i>=0;i--)
        {
            for(int sum1=0;sum1<=totalSum;sum1++)
            {
                if(i==n)
                {
                    int sum2 = totalSum - sum1;
                    dp[i][sum1] = Math.abs(sum1-sum2);
                }
                else
                {
                    int notTake = dp[i+1][sum1];
                    int take = Integer.MAX_VALUE;
                    if(sum1+arr[i] <=totalSum)
                    take = dp[i+1][sum1+arr[i]];
                    
                    dp[i][sum1] = Math.min(take,notTake);
                }
            }
        }
        return dp[0][0];
    }

    public static int minDifference(int arr[]) {
        // Your code goes here
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int n = arr.length;
        int[][] dp = new int[n][sum + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return minDifferenceUtil(arr, sum, 0, 0, n, dp);
    }

    private static int minDifferenceUtil(int[] arr, int sum, int s, int i, int n, int[][] dp) {
        if (i == n) {
            int diff = sum - s;
            return Math.abs(diff - s);
        }
        if (dp[i][s] != -1) {
            return dp[i][s];
        }
        // inlcude
        int include = minDifferenceUtil(arr, sum, s + arr[i], i + 1, n, dp);
        // not include
        int notinclude = minDifferenceUtil(arr, sum, s, i + 1, n, dp);
        return dp[i][s] = Math.min(include, notinclude);
    }

}