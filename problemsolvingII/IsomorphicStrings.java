import java.util.HashMap;

public class IsomorphicStrings {
    static void main() {
        System.out.println(areIsomorphic("aab",
                "xyz"));
    }

    public static boolean areIsomorphic(String s1, String s2) {
        // code here
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (!map.containsKey(c1) && !map2.containsKey(c2)) {
                map.put(c1, c2);
                map2.put(c2, c1);
            } else {
                if (map.containsKey(c1) && map.get(c1) != c2) {
                    return false;
                }
                if (map2.containsKey(c2) && map2.get(c2) != c1) {
                    return false;
                }
            }
        }
        return true;
    }
}
