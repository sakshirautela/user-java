public class q4 {
    public static void main(String[] args) {
    }
    public int countCoprime(int[][] a) {
        int M = 1_000_000_007;
        int m = a.length;
        int mx = 150;
        int[][] b = a;
        long[] d = new long[mx + 1];
        d[0] = 1;
        for (int i = 0; i < m; i++) {
            long[] n = new long[mx + 1];
            for (int g = 0; g <= mx; g++) {
                if (d[g] == 0) continue;
                for (int x : a[i]) {
                    int ng = g == 0 ? x : gcd(g, x);
                    n[ng] = (n[ng] + d[g]) % M;
                }
            }
            d = n;
        }
        return (int) d[1];
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
