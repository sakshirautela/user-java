public class NumberofWaystoPaintNx3Grid {
    public static void main(String[] args) {
        System.out.println(numOfWays(3));
    }
    static long argb=6,argr=6,brgb,brgr,mod=1000000007;
    public static int numOfWays(int n) {
        for (int i = 2; i <=n; i++) {
            brgr=argb*2+argr*3;
            brgb=argb*2+argr*2;
            argb=brgb%mod;
            argr=brgr%mod;            
        }
        return (int) ((argb+argr)%mod);
    }
    public int numOfWays2(int n) {
        int MOD = 1_000_000_007;

        long a = 6; // typeA count (3-color row)
        long b = 6; // typeB count (2-color row)

        for (int i = 2; i <= n; i++) {
            long nextA = (a * 2 + b * 2) % MOD;
            long nextB = (a * 2 + b * 3) % MOD;
            a = nextA;
            b = nextB;
        }

        return (int)((a + b) % MOD);
    }
}