
public class SumOfStringAfterDigits {
    public static int getLucky(String s, int k) {
        int result = 0;
        int a = 0;
        for (char ch : s.toCharArray()) {
            a = ch - 'a' + 1;
            result += a % 10;
            a = a / 10;
            result += a % 10;
            a = a / 10;
        }
        if (k == 1) {
            return result;
        }
        for (int i = 1; i < k; i++) {
            a = result;
            result = 0;
            while (a > 0) {
                result += a % 10;
                a /= 10;
            }
        }
        return result;
    }

    public static void main(String arga[]) {
        System.out.println(getLucky("leetcode", 2));
    }
}
