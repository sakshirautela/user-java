public class RemoveZerosinDecimalRepresentation {
    public static void main(String[] args) {
        System.out.println(removeZeros(215801825));
    }
    public static long removeZeros(long n) {
        long place = 1;
        long result = 0;

        while (n > 0) {
            long rem = n % 10;
            if (rem != 0) {
                result = rem * place + result;
                place *= 10;
            }
            n /= 10;
        }

        return result;
    }

}
