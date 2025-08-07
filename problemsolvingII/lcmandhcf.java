public class lcmandhcf {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int g = gcd(a, b);
        return new int[]{(a * b) / g,g};
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
