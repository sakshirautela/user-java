public class CountDigits {
    public static void main(String[] args) {
        System.out.println();
    }

    static int evenlyDivides(int n) {
        // code here
        int digit = n;
        int result = 0;
        while (n > 0) {
            int r = (n % 10);
            if (digit % r == 0) {
                result++;
            }
            n /= 10;
        }
        return result;
    }
}
