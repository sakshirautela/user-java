import java.util.Arrays;

public class LexicographicallySmallestGeneratedString {
    static void main() {
        System.out.println(generateString("FFFTFTTFTTFTTTTFFTTFFFT", "aaaxbxxbxxbxxxxxaxxxaaxx"));
    }

    public static String generateString2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] s = new char[n + m - 1];
        int[] fixed = new int[n + m - 1];
        Arrays.fill(s, 'a');
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = i; j < i + m; j++) {
                    if (fixed[j] == 1 && s[j] != str2.charAt(j - i)) {
                        return "";
                    } else {
                        s[j] = str2.charAt(j - i);
                        fixed[j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean flag = false;
                int idx = -1;
                for (int j = i + m - 1; j >= i; j--) {
                    if (str2.charAt(j - i) != s[j]) {
                        flag = true;
                    }
                    if (idx == -1 && fixed[j] == 0) {
                        idx = j;
                    }
                }
                if (flag) {
                    continue;
                } else if (idx != -1) {
                    s[idx] = 'b';
                } else {
                    return "";
                }
            }
        }
        return new String(s);
    }

    public static String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] arr = new char[n + m - 1];
        boolean[] fix = new boolean[n + m - 1];
        for (int i = 0; i < n + m - 1; i++) {
            arr[i] = 'a';
        }
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (fix[j + i] && arr[i + j] != str2.charAt(j)) {
                        return "";
                    } else {
                        fix[j + i] = true;
                        arr[j + i] = str2.charAt(j);
                    }
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (str1.charAt(i) == 'F') {
                boolean isEqual = true;
                int f = -1;
                for (int j = 0; j < m; j++) {
                    if (arr[i + j] != str2.charAt(j)) {
                        isEqual = false;
                    }
                    if (f == -1 && !fix[i+j]) {
                        f = j;
                    }
                }
                if (isEqual) {
                    if (f != -1) {
                        arr[i + f] = (str2.charAt(f) == 'a') ? 'b' : 'a';
                    } else {
                        return "";
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n - 1 + m; j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}
