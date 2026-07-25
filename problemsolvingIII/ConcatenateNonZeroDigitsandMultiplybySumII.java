package problemsolvingIII;

public class ConcatenateNonZeroDigitsandMultiplybySumII {
    public static void main(String[] args) {
        int[] res = sumAndMultiply("10203004", new int[][]{{0, 7}});
        for (int resi : res) {
            System.out.print(resi + " ");
        }
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;
        long[] sum = new long[n + 1];
        long[] nums = new long[n + 1];
        int[] res = new int[q];
        int[] len = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            nums[i + 1] = ((c == '0') ? nums[i] : nums[i] * 10 + (s.charAt(i) - '0')) % mod;
            sum[i + 1] = sum[i] + c - '0';
            len[i + 1] = len[i] + (c == '0' ? 0 : 1);
        }
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int length = len[r] - len[l];
            long range_num = (nums[r] - ((nums[l] * pow10[length]) % mod) + mod) % mod;
            long range_sum = sum[r] - sum[l];
            res[i] = (int) ((range_sum * range_num) % mod);
        }
        return res;
    }

    static int mod = 1_000_000_007;
    static final long[] pow10 = new long[100001];

        static {
        pow10[0] = 1;
        for (int i = 1; i < 100001; ++i) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }
    }
    public int[] sumAndMultiplyFast(String s, int[][] queries) {
        long MOD = 1_000_000_007;
        int len = s.length();

        long[] preSum = new long[len + 1];
        long[] preProduct = new long[len + 1];
        int[] nonZeroCnt = new int[len + 1];
        long[] p10 = new long[len + 1];
        p10[0] = 1;
        for (int i = 0; i < len; i++) {
            p10[i + 1] = (p10[i] * 10) % MOD;

            int digit = s.charAt(i) - '0';
            preSum[i + 1] = preSum[i] + digit;

            if (digit == 0) {
                preProduct[i + 1] = preProduct[i];
                nonZeroCnt[i + 1] = nonZeroCnt[i];
            } else {
                preProduct[i + 1] = (preProduct[i] * 10 + digit) % MOD;
                nonZeroCnt[i + 1] = nonZeroCnt[i] + 1;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            long sum = preSum[end + 1] - preSum[start];

            int cnt = nonZeroCnt[end + 1] - nonZeroCnt[start];

            long subtract = (preProduct[start] * p10[cnt]) % MOD;
            long x = (preProduct[end + 1] - subtract + MOD) % MOD;

            res[i] = (int) ((x * sum) % MOD);
        }

        return res;
    }

}
