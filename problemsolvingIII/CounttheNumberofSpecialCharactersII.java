package problemsolvingIII;

import java.util.Arrays;
import java.util.HashSet;

public class CounttheNumberofSpecialCharactersII {
    static void main() {
        System.out.println(numberOfSpecialChars("AbBCab"));
    }

    public static int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] upper = new int[26];
        int[] lower = new int[26];
        int[] valid = new int[26];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c >= 'a') {
                lower[c - 'a']++;
                if (upper[c - 'a'] > 0) {
                    valid[c - 'a'] = -1;
                }
            } else {
                upper[c - 'A']++;
                if (lower[c - 'A'] >= 1 && upper[c - 'A'] == 1) {
                    valid[c - 'A'] = 1;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (valid[i] == 1) {
                count++;
            }
        }
        return count;
    }
        public static int numberOfSpecialCharsFast(String word) {
            int n = word.length();
            char[] chars = word.toCharArray();
            int[] lastLower = new int[26];
            int[] firstUpper = new int[26];
            Arrays.fill(lastLower, -1);
            Arrays.fill(firstUpper, -1);
            for (int i = 0; i < n; i++) {
                if (chars[i] >= 'a') {
                    lastLower[chars[i] - 'a'] = i;
                } else if (firstUpper[chars[i] - 'A'] == -1) {
                    firstUpper[chars[i] - 'A'] = i;
                }
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (lastLower[i] != -1 && lastLower[i] < firstUpper[i]) {
                    ans++;
                }
            }
            return ans;
        }
}
