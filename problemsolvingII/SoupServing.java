public class SoupServing {
    public static void main(String[] args) {
        System.out.println(soupServings(50));
    }

    public static double soupServings(int n) {
        if(n>=4800){
            return 1;
        }
        return soupServingsHelper(n, n) * 0.25;
    }

    private static double soupServingsHelper(int A, int B) {
        if (A <= 0 && B > 0) {
            return 1;
        }
        if (B <= 0 && A > 0) {
            return 0;
        }
        if ((A & B) == 0) {
            return 0.5;
        }
        return soupServingsHelper(A - 100, B) +
                soupServingsHelper(A - 75, B - 25) +
                soupServingsHelper(A - 50, B - 50) +
                soupServingsHelper(A - 25, B - 75);
    }
}