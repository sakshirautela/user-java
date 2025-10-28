public class MinimumOperationstoMaketheIntegerZero {
    public static void main(String[] args) {
        System.out.println(makeTheIntegerZero(5, 7));
    }

    public static int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long x = num1 - ((long) num2 * i);
            if (x < i) {
                return -1;
            }
            if (i >= Long.bitCount(x)) {
                return i;
            }
        }
        return -1;
    }
}