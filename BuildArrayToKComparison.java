import java.util.Arrays;

public class BuildArrayToKComparison {
    private static int Mod = 1000000007;

    // public static int numOfArrays(int n, int m, int k) {
    //     int dp[][][] = new int[n + 1][m + 1][k + 1];
    //     for (int i = 0; i <= n; i++) {
    //         for (int j = 0; j <= m; j++) {
    //             Arrays.fill(dp[i][j], -1); // Initialize with -1
    //         }
    //     }
    //     return solve(0, n, 0, m, 0, k, dp);
    // }

    // private static int solve(int idx, int n, int maxsofar, int m, int cost, int k, int dp[][][]) {
    //     if (idx == n) {
    //         if (cost == k) {
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if (dp[idx][maxsofar][cost] != -1) {
    //         return dp[idx][maxsofar][cost];
    //     }
    //     int result = 0;
    //     for (int i = 1; i <= m; i++) {
    //         if (maxsofar < i) {
    //             result = (result + solve(idx + 1, n, i, m, cost + 1, k, dp)) % (Mod);
    //         } else {
    //             result = (result + solve(idx + 1, n, maxsofar, m, cost, k, dp)) % (Mod);
    //         }
    //     }
    //     return dp[idx][maxsofar][cost] = (result)%Mod;
    // }

    public static void main(String[] args) {
        System.out.println(numOfArrays(3, 5, 2));
    }
}
