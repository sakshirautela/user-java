public class PalindromePartitioningII {
    static void main() {
        System.out.println(minCut("aab"));
    }

    public static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = b && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = i;
                for (int j = 0; j < i; j++) {
                    cuts[i] = Math.min(cuts[j]+1, cuts[i]);
                }
            }
        }
        PalindromicSubstrings.printdp(dp);
        for (int i = 0; i < n; i++) {
            System.out.print(cuts[i]+" ");
        }
        return cuts[n - 1];
    }
}
