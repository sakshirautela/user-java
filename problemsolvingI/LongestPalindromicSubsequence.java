
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalinSubseq("bbbab"));
    }

    public static int longestPalinSubseq(String s) {
        // code here
//        int[] curr = new int[n];
//        int[] prev = new int[n];
//        for (int i = n - 1; i >= 0; --i) {
//            curr[i] = 1;
//            for (int j = i + 1; j < n; ++j) {
//
//                if (s.charAt(i) == s.charAt(j)) {
//
//                    curr[j] = prev[j - 1] + 2;
//                } else {
//                    curr[j] = Math.max(prev[j], curr[j - 1]);
//                }
//            }
//
//            prev = curr.clone();
//        }
//        return curr[n - 1];
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        MinDifficultyJobScheduling.printdp(dp);
        return n-dp[0][n - 1];
    }
}
