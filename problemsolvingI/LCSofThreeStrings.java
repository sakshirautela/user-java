public class LCSofThreeStrings {
    public static void main(String[] args) {
        System.out.println(lcsOf3("LYAvLIbv5qXc2ltSfaSfPEL3gelnxJGfHX82BO3yB",
                "t0AFUXwc6muFu4VpGs441o4xrwGmJnnN4us5CfY", "XNtaC0L3SG4YTKHvFiFGBIHhJF7v7C22k7kqTzA"));
    }

    static int lcsOf3(String s1, String s2, String s3) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        int[][][] dp = new int[n][m][l];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return solve(0, 0, 0, s1, s2, s3, n, m, l, dp);
    }
    
    private static int solve(int i, int j, int k, String s1, String s2, String s3, int n1, int n2, int n3, int[][][] dp) {
        if (i >= n1 || j >= n2 || k >= n3) {
            return 0;
        }
        
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
            dp[i][j][k] = 1 + solve(i + 1, j + 1, k + 1, s1, s2, s3, n1, n2, n3, dp);
        } else {
            dp[i][j][k] = Math.max(
                Math.max(
                    solve(i + 1, j, k, s1, s2, s3, n1, n2, n3, dp),
                    solve(i, j + 1, k, s1, s2, s3, n1, n2, n3, dp)
                ),
                solve(i, j, k + 1, s1, s2, s3, n1, n2, n3, dp)
            );
        }
        
        return dp[i][j][k];
    }

    static int lcsOf3WhenSequential(String s1, String s2, String s3) {
        // code here
        int ans = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                String s = s1.substring(i, j);
                if (s2.indexOf(s) != -1 && s3.indexOf(s) != -1) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
}