import java.util.HashMap;

public class LongestBalancedSubstringI {
    static void main() {
        System.out.println(longestBalanced("abbac"));
    }

    public static int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                boolean is = true;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                int f = map.get(s.charAt(i));
                for (char c : map.keySet()) {
                    if (map.get(c) != f) {
                        is = false;
                    }
                }
                if (is) {
                    res = Math.max(res, j - i+1);
                }
            }
        }
        return res;
    }
}