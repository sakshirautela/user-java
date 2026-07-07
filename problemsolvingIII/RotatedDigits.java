package problemsolvingIII;

import java.util.HashSet;
import java.util.List;

public class RotatedDigits {
    static void main() {
        System.out.println(rotatedDigits(857));
    }

    public static int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += (isRoted(i)) ? 1 : 0;
        }
        return res;
    }

    static HashSet<Integer> hs = new HashSet<>(List.of(2, 5, 6, 9));
    static HashSet<Integer> invalid = new HashSet<>(List.of(3, 4, 7));

    private static boolean isRoted(int num) {
        boolean res = false;
        while (num > 0) {
            int rem = num % 10;
            if (hs.contains(rem)) {
                res = true;
            }
            if (invalid.contains(rem)) {
                return false;
            }
            num = num / 10;
        }
        return res;
    }

    public int rotatedDigitsBetter(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Integer[][][] memo = new Integer[digits.length][2][2];
        return dfs(0, 1, 0, digits, memo);
    }

    private int dfs(int pos, int tight, int changed, char[] digits, Integer[][][] memo) {
        if (pos == digits.length) {
            return changed == 1 ? 1 : 0;
        }
        if (memo[pos][tight][changed] != null) {
            return memo[pos][tight][changed];
        }
        int limit = tight == 1 ? digits[pos] - '0' : 9;
        int count = 0;
        for (int d = 0; d <= limit; d++) {
            if (d == 3 || d == 4 || d == 7) {
                continue;
            }
            int nextTight = tight == 1 && d == limit ? 1 : 0;
            int nextChanged = changed;
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                nextChanged = 1;
            }
            count += dfs(pos + 1, nextTight, nextChanged, digits, memo);
        }
        memo[pos][tight][changed] = count;
        return count;
    }

    public int rotatedDigitsDP(int n) {
        int[] dp = new int[n + 1];
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                } else {
                    dp[i] = 0;
                }
            } else {
                int a = dp[i / 10];
                int b = dp[i % 10];

                if (a == 1 && b == 1) {
                    dp[i] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                } else {
                    dp[i] = 0;
                }
            }
        }
        return count;
    }
}