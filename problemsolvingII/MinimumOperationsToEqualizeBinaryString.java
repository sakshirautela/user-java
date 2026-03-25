public class MinimumOperationsToEqualizeBinaryString {
    static void main() {
        System.out.println(minOperations("000", 2));
    }

    public static int minOperations(String s, int k) {
        int one = 0;
        int zero = 0;
        int n = s.length();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        int res = zero / k;
        one %= k;
        if (res > 0) {
            one = k;
        }
        zero %= k;
        if (zero + one == k && zero + one == k + 1) {
            return res + 2;
        }
        return res;
    }
}
