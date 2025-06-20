
public class TotalDecodingMessagesGFG {
    public static void main(String[] args) {
        System.out.println(countWays("123"));
    }

    public static int countWays(String digits) {
        // code here
        int mod = 1000000007, n = digits.length();
        char[] s = digits.toCharArray();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            if ((s[i - 2] == '1') || (s[i - 2] == '2' && s[i - 1] <= '6')) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }
        return dp[n];
    }
}
