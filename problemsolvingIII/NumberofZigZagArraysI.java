package problemsolvingIII;

public class NumberofZigZagArraysI {
    static void main() {
        System.out.println(zigZagArraysDiff(3, 4, 5));
    }
//
//    public static int zigZagArrays(int n, int l, int r) {
//        int m = r - l + 1;
//        int[][][] dp = new int[n+1][2][m];
//        for (int i = 1; i <= m; i++) {
//            dp[i][0][] = 1;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= l; j++) {
//
//            }
//            for(int j = 1; j <= r; j++) {
//
//            }
//        }
//    }
//
        private static final int MOD = 1000000007;

        public static int zigZagArraysDiff(int n, int l, int r) {
            int m = r - l + 1;

            int[] dp = new int[m];
            java.util.Arrays.fill(dp, 1);

            for (int len = 2; len <= n; len++) {

                if ((len & 1) == 0) {
                    long pref = 0;

                    for (int i = 0; i < m; i++) {
                        int old = dp[i];

                        dp[i] = (int) pref;

                        pref = (pref + old) % MOD;
                    }
                }
                else {
                    long suff = 0;

                    for (int i = m - 1; i >= 0; i--) {
                        int old = dp[i];

                        dp[i] = (int) suff;

                        suff = (suff + old) % MOD;
                    }
                }
            }

            long ans = 0;

            for (int x : dp) {
                ans = (ans + x) % MOD;
            }

            return (int) ((ans * 2) % MOD);
        }
}
