public class convertmul {
    public static void main(String args[]) {
        String num1 = "12";

        String num2 = "12";

        System.out.println(multiplyStrings(num1, num2)); // Output: 144
    }

    public static String multiplyStrings(String s1, String s2) {
        int sign = (s1.charAt(0) == '-') ? -1 : 1;
        sign *= (s2.charAt(0) == '-') ? -1 : 1;

        int n = s1.length();
        int m = s2.length();

        int idx = (s1.charAt(0) != '-' && s1.charAt(0) != '+') ? 0 : 1;
        while (idx < n && s1.charAt(idx) == '0') {
            idx++;
        }
        if (idx == n) {
            return "0";
        }
        s1 = s1.substring(idx);
        n = s1.length();

        int idx2 = (s2.charAt(0) != '-' && s2.charAt(0) != '+') ? 0 : 1;
        while (idx2 < m && s2.charAt(idx2) == '0') {
            idx2++;
        }
        if (idx2 == m) {
            return "0";
        }
        s2 = s2.substring(idx2);
        m = s2.length();

        int mul[] = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                mul[i + j + 1] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        for (int i = n + m - 1; i > 0; i--) {
            mul[i - 1] += mul[i] / 10;
            mul[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int index = (mul[0] == 0) ? 1 : 0;
        for (; index < n + m; index++) {
            sb.append(mul[index]);
        }

        if (sign == -1) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
}
