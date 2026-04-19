package problemsolvingIII;

public class CheckforPower {
    static void main() {
        System.out.println(isPower(2,8));
    }

    public static boolean isPower(int x, int y) {
        if (x == 1) {
            return false;
        }
        if (y == 1) {
            return true;
        }
        if (y % x != 0) {
            return false;
        }
        double res = Math.log(y) / Math.log(x);
        return Math.abs(res - Math.round(res)) < 1e-10;
    }
        public static boolean isPowerComplex(int x, int y) {
        // code here
        if (x == 1) {
            return false;
        }
        if (y == 1) {
            return true;
        }
        if (y % x != 0) {
            return false;
        }
        int a = x;
        while (y > a) {
            a = a * x;
            //System.out.println(a);
        }
        return a == y;
    }
}
