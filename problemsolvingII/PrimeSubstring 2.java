import java.util.HashMap;
import java.util.HashSet;

public class PrimeSubstring {
    public static void main(String[] args) {

        System.out.println(solve("2609800966"));
    }
    static int solve(String s) {
        // code here
        int n = s.length();
        int result=0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = i; j < n; j++) {
                int digit = s.charAt(j) - '0';
                num = num * 10 + digit;
                if (isPrime(num) ) {
                    System.out.println(num+" "+i+" "+j);
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
