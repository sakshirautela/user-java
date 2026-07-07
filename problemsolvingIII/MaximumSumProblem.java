package problemsolvingIII;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSumProblem {
    static void main() {
        System.out.println(maxSum(12));
    }
    public static int maxSumDP(int n) {
        if (n == 0) {
            return 0;
        }
        // Create DP array of size n+1
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill DP array from 2 to n
        for (int i = 2; i <= n; i++) {

            // Compute sum by breaking the number
            int sum = dp[i / 2] + dp[i / 3] + dp[i / 4];

            // Store maximum of keeping i or breaking it
            dp[i] = Math.max(i, sum);
        }

        // Return final answer
        return dp[n];
    }
    public static int maxSum(int n) {
        // code here.
        if(n<=1){
            return n;
        }
        int sum=maxSum(n/2)+maxSum(n/3)+maxSum(n/4);
        return Math.max(n,sum);
    }

}

