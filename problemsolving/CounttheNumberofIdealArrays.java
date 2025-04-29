import java.math.BigInteger;

public class CounttheNumberofIdealArrays {
    public static void main(String[] args) {
        System.out.println(idealArrays(3,4));
    }

    static final int mod = 1000000007;
    static int[] factMemo = new int[100000];
    static int[][] dp = new int[100000][15];

    static long power(long a, long b, long m) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }

    static long fact(int x) {
        if (x == 0)
            return 1;
        if (factMemo[x] != 0)
            return factMemo[x];
        factMemo[x] = (int) ((1L * x * fact(x - 1)) % mod);
        return factMemo[x];
    }

    static long mod_inv(int a, int b) {
        return fact(a) * power(fact(b), mod - 2, mod) % mod * power(fact(a - b), mod - 2, mod) % mod;
    }

    public static int idealArrays(int n, int maxi) {
        int m = Math.min(n, 14);
        for (int i = 1; i <= maxi; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = 0;
        for (int i = 1; i <= maxi; i++) {
            dp[i][1] = 1;
            for (int j = 2; i * j <= maxi; j++)
                for (int k = 1; k < m; k++)
                    dp[i * j][k + 1] += dp[i][k];
        }
        long res = 0;
        for (int i = 1; i <= maxi; i++)
            for (int j = 1; j <= m; j++)
                res = (res + mod_inv(n - 1, n - j) * dp[i][j]) % mod;
        return (int) res;
    }

	public static final int MODULO = (int) 1e9 + 7;

	public static int idealArrays2(int n, int maxValue) {
		int[] minDivisor = new int[maxValue + 1];
		for (int p = 2; p <= maxValue; p++) {
			if (minDivisor[p] != 0)
				continue;
			for (int i = p; i <= maxValue; i += p)
				if (minDivisor[i] == 0)
					minDivisor[i] = p;
		}
		
		int maxPow = (int) (Math.log(maxValue) / Math.log(2));
		int[] binCoeff = new int[maxPow + 1];
		BigInteger b = BigInteger.ONE;
		BigInteger bigMod = BigInteger.valueOf(MODULO);
		for (int i = 1; i <= maxPow; i++) {
			b = b.multiply(BigInteger.valueOf(n + i - 1));
			b = b.divide(BigInteger.valueOf(i));
			binCoeff[i] = b.mod(bigMod).intValue();
		}
		
		int s = 0;
		for (int i = 1; i <= maxValue; i++) {
			int x = i;
			long prodBin = 1;
			while (x > 1) {
				int p = minDivisor[x];
				int w = 0;
				do {
					w++;
					x /= p;
				} while (x % p == 0);
				prodBin = prodBin * binCoeff[w] % MODULO;
			}
			s = (s + (int) prodBin) % MODULO;
		}
		return s;
	}
}
