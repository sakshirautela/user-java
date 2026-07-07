package problemsolvingIII;

public class BinaryStringswithEqualSumofTwoHalves {
    static void main() {

    }
    static long power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) > 0)
                ans = (ans * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }
    static  int MOD = (int)1e9 + 7;
    public static int computeValue(int n) {
        // code here
            long fact1 = 1;
            long fact2 = 1;

            // Compute (2n)!
            for (int i = 1; i <= 2 * n; i++)
                fact1 = (fact1 * i) % MOD;

            // Compute n!
            for (int i = 1; i <= n; i++)
                fact2 = (fact2 * i) % MOD;

            long denom = (fact2 * fact2) % MOD;

            long ans = (fact1 * power(denom, MOD - 2)) % MOD;

            return (int)ans;
    }
}
