package com.learn.java.problemsolving;

public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {

    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= mod;
            if (i >= low && i <= high) {
                ans += dp[i];
                ans %= mod;
            }
        }
        return ans;
    }

    private static final int MOD = (int) 1e9 + 7;

    public int countGoodStrings2(int low, int high, int zero, int one) {
        if (zero > one) {
            return countGoodStrings(low, high, one, zero);
        }
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= one) {
                dp[i] = (dp[i - zero] + dp[i - one]) % MOD;
            } else if (i >= zero) {
                dp[i] = dp[i - zero] % MOD;
            }
            if (i >= low) {
                ans = (ans + dp[i]) % MOD;
            }
        }
        return ans;
    }
}