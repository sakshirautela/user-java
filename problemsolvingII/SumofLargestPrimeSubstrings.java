import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SumofLargestPrimeSubstrings {
    public static void main(String[] args) {
        System.out.println(sumOfLargestPrimes("111"));
    }

    public static long sumOfLargestPrimes(String s) {
        int n = s.length();
        HashSet<Long> hs = new HashSet<>();
        long first = 0, second = 0, third = 0;
        for (int i = 0; i < n; i++) {
            long num = 0;
            for (int j = i; j < n; j++) {
                int digit = s.charAt(j) - '0';
                num = num * 10 + digit;
                if (isPrime(num) && !hs.contains(num)) {
                    hs.add(num);
                    if (num > first) {
                        third = second;
                        second = first;
                        first = num;
                    } else if (second < num) {
                        third = second;
                        second = num;
                    } else if (num > third) {
                        third = num;
                    }
                }
            }
        }
        System.out.println(hs);
        System.out.println(first+" "+second+" "+third);
        return first + second + third;
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
