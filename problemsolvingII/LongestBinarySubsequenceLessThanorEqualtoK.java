public class LongestBinarySubsequenceLessThanorEqualtoK {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
    }

    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        int len = 0;
        int num=0;
        int pow = -1;
        for (int i = n - 1; i >= 0; i--) {
            pow++;
            if (s.charAt(i) == '0') {
                len++;
            } else if (num<=k && 1 << pow <= k) {
                num+=(1<<pow);
                len++;
            }
        }
        return len;
    }

    public static int longestSubsequenceWrong(String s, int k) {
        int n = s.length();
        return getValidMaxLength(new StringBuilder(), s, k, 0, n);
    }

    private static int getValidMaxLength(StringBuilder sb, String s, int k, int i, int n) {
        if (i == n) {
            return 0;
        }
        int a = 0;
        int len = sb.length();
        if (isValid(sb, k, len)) {
            a = len;
        }
        sb.append(s.charAt(i));
        int include = getValidMaxLength(sb, s, k, i + 1, n);
        sb.deleteCharAt(sb.length() - 1);
        int notinclude = getValidMaxLength(sb, s, k, i + 1, n);
        return Math.max(a, Math.max(include, notinclude));
    }

    private static boolean isValid(StringBuilder sb, int k, int len) {
        int a = 0;
        int idx = len - 1;
        int pow = 0;
        while (idx >= 0) {
            a += (sb.charAt(idx) - '0') * Math.pow(2, pow);
            pow++;
            idx--;
            if (a > k) {
                return false;
            }
        }
        return a <= k;
    }
}