public class PalindromicSubstrings {
    static void main() {
        System.out.println(countSubstringsDP("aabvmm"));
    }

    public static int countSubstringsDP(String s) {
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
        printdp(dp);
        return ans;
    }

    static void printdp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                System.out.println(s.substring(l, r + 1));
                l--;
                result++;
                r++;
            }
            l = i - 1;
            r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                result++;
                r++;
            }
        }
        return result;
    }
}