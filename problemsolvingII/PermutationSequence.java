import java.util.ArrayList;

public class PermutationSequence {
    public static void main(String[] m) {
        System.out.println(getPermutation(4, 9));
    }

    static int[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public static String getPermutation2(int n, int k) {
         ArrayList<Character> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add((char) ('0' + i));
        }
        StringBuilder sb=new StringBuilder();
        while (n>0) {
            int fact=factorial[n-1];
            int d=k/fact;
            char c=digits.remove(d);
            n--;
            sb.append(c);
            k-=d*fact;
        }
        return sb.toString();
    }
    public static String getPermutation(int n, int k) {
        ArrayList<Character> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add((char) ('0' + i));
        }
        System.out.println(digits);
        System.out.println(factorial.length);
        return getPermutationUtill(digits, n, k);
    }

    private static String getPermutationUtill(ArrayList<Character> digits, int n, int k) {
        if (n == 1) {
            return "" + digits.remove(0);
        }
        int fact = factorial[n - 1];
        int d = (k - 1) / fact;
        char ch = digits.remove(d);
        return ch + getPermutationUtill(digits, n-1, k - (d * fact));
    }
}
