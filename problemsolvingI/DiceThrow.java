public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(noOfWays(0, 0, 0));
    }
    static int noOfWays(int m, int n, int x) {
        // code here
        
        // Create a 2D dp array with (n+1) rows and (x+1)
        // columns dp[i][j] will store the number of ways to
        // get a sum of 'j' using 'i' dice
        int[][] dp = new int[n + 1][x + 1];

        // Base case: There is 1 way to get a sum of 0 with
        // 0 dice
        dp[0][0] = 1;

        // Loop through each dice (i) from 1 to n
        for (int i = 1; i <= n; i++) {
          
            // Loop through each sum (j) from 1 to x
            for (int j = 1; j <= x; j++) {
              
                // Loop through all possible dice values (k)
                // from 1 to m and if the sum j - k is valid
                // (non-negative), add the number of ways
                // from dp[i-1][j-k]
                for (int k = 1; k <= m && j - k >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        // The result will be in dp[n][x], which contains
        // the number of ways to get sum 'x' using 'n' dice
        return dp[n][x];
    }
}