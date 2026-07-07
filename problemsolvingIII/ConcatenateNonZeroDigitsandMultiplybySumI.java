package problemsolvingIII;

public class ConcatenateNonZeroDigitsandMultiplybySumI {
    static void main() {
        System.out.println(sumAndMultiply(10203004));
    }

    public static long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            if(digit!=0){
                num=(num*10)+digit;
            }
            n /= 10;
        }
        long ans = 0;
        while (num > 0) {
            long digit = num%10;
            ans=(ans*10)+digit;
            num /= 10;
        }
        return sum * ans;
    }
}
