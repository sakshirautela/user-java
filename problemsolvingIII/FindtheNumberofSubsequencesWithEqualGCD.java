package problemsolvingIII;

import java.util.Arrays;

public class FindtheNumberofSubsequencesWithEqualGCD {
    public int subsequencePairCount(int[] nums) {
        int max=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int n=nums.length;
        int[][][] dp=new int[n+1][max+1][max+1];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return dfs(nums, 0, 0, 0,dp)-1;
    }

    static int mod = 1000000007;

    private int dfs(int[] nums, int i, int j, int k, int[][][] dp) {
        if (i == nums.length) {
            return j == k ? 1 : 0;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        long res = dfs(nums, i+1, j, k, dp);
        res = (res + dfs(nums, i + 1, j, gcd(k, nums[i]), dp)) % mod;
        res = (res + dfs(nums, i + 1, gcd(j, nums[i]), k, dp)) % mod;
        return dp[i][j][k]=Math.toIntExact(res);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    // https://www.youtube.com/@0x3f
    /*class Solution {
        private static final int MOD = 1_000_000_007;
        private static final int MX = 201;

        private static final int[][] lcms = new int[MX][MX];
        private static final int[] pow2 = new int[MX];
        private static final int[] pow3 = new int[MX];
        private static final int[] mu = new int[MX];
        private static boolean initialized = false;

        // 这样写比 static block 快
        public Solution() {
            if (initialized) {
                return;
            }
            initialized = true;

            for (int i = 1; i < MX; i++) {
                for (int j = 1; j < MX; j++) {
                    lcms[i][j] = lcm(i, j);
                }
            }

            pow2[0] = pow3[0] = 1;
            for (int i = 1; i < MX; i++) {
                pow2[i] = pow2[i - 1] * 2 % MOD;
                pow3[i] = (int) ((long) pow3[i - 1] * 3 % MOD);
            }

            mu[1] = 1;
            for (int i = 1; i < MX; i++) {
                for (int j = i * 2; j < MX; j += i) {
                    mu[j] -= mu[i];
                }
            }
        }

        public int subsequencePairCount(int[] nums) {
            int m = 0;
            for (int x : nums) {
                m = Math.max(m, x);
            }

            // cnt[i] 表示 nums 中的 i 的倍数的个数
            int[] cnt = new int[m + 1];
            for (int x : nums) {
                cnt[x]++;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = i * 2; j <= m; j += i) {
                    cnt[i] += cnt[j]; // 统计 i 的倍数的个数
                }
            }

            int[][] f = new int[m + 1][m + 1];
            for (int g1 = 1; g1 <= m; g1++) {
                for (int g2 = 1; g2 <= m; g2++) {
                    int l = lcms[g1][g2];
                    int c = l <= m ? cnt[l] : 0;
                    int c1 = cnt[g1];
                    int c2 = cnt[g2];
                    f[g1][g2] = (int) (((long) pow3[c] * pow2[c1 + c2 - c * 2] - pow2[c1] - pow2[c2] + 1) % MOD);
                }
            }

            // 倍数容斥
            long ans = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= m / i; j++) {
                    for (int k = 1; k <= m / i; k++) {
                        ans += mu[j] * mu[k] * f[j * i][k * i];
                    }
                }
            }
            return (int) ((ans % MOD + MOD) % MOD); // 保证 ans 非负
        }

        private static int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }

        private static int lcm(int a, int b) {
            return a / gcd(a, b) * b;
        }
        }
     */
    /*class Solution {

        static final int MOD = 1000000007;

        public int subsequencePairCount(int[] nums) {
            int m = 0;
            for (int num : nums) {
                m = Math.max(m, num);
            }

            int[][] dp = new int[m + 1][m + 1];
            dp[0][0] = 1;

            for (int num : nums) {
                int[][] ndp = new int[m + 1][m + 1];
                for (int j = 0; j <= m; j++) {
                    int divisor1 = gcd(j, num);
                    for (int k = 0; k <= m; k++) {
                        int val = dp[j][k];
                        if (val == 0) {
                            continue;
                        }
                        int divisor2 = gcd(k, num);
                        ndp[j][k] = (ndp[j][k] + val) % MOD;
                        ndp[divisor1][k] = (ndp[divisor1][k] + val) % MOD;
                        ndp[j][divisor2] = (ndp[j][divisor2] + val) % MOD;
                    }
                }
                dp = ndp;
            }

            int ans = 0;
            for (int j = 1; j <= m; j++) {
                ans = (ans + dp[j][j]) % MOD;
            }
            return ans;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a;
                a = b;
                b = temp % b;
            }
            return a;
        }
    }*/
}