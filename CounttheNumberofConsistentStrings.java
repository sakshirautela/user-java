import java.util.HashSet;

public class CounttheNumberofConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            if (check(w, s)) {
                ++ans;
            }
        }
        return ans;
    }

    private static boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); ++i) {
            if (!s[w.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static int countConsistentStrings2(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<Character>();
        for (char ch : allowed.toCharArray()) {
            hs.add(ch);
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            boolean isContain = false;
            for (char ch : s.toCharArray()) {
                if (!hs.contains(ch)) {
                    isContain = true;
                    break;
                }
            }
            res += (isContain) ? 0 : 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[] {}));
    }
}
