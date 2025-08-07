public class checkDivisibiltyBySumandProduct {
    public static void main(String[] args) {
        System.out.println(checkDivisibility(99));
    }

    public static boolean checkDivisibility(int n) {
        int t = n;
        int p = 1, s = 0;

        while (n > 0) {
            int r = n % 10;
            p *= r;
            s += r;
            n /= 10;
        }

        return (t%(p + s )== 0);
    }
}