import java.util.*;
public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        if ((s.length() != goal.length())) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < goal.length() - 1; i++) {
            char temp = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char ch = s.charAt(j);
                String res = s.substring(0, i) + ch + s.substring(i + 1, j) + temp + s.substring(j + 1);
                if (res.equals(goal)) {
                    result = true;
                    break;
                }
                System.out.println(res);
            }
        }
        return result;
    }

    public static boolean buddyStrings2(String s, String goal) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ghs = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
        }
        for (char ch : goal.toCharArray()) {
            ghs.put(ch, ghs.getOrDefault(ch, 0) + 1);
        }
        if (s.equals(goal) && ghs.size() > 1) {
            return false;
        }
        for (char ch : hs.keySet()) {
            if (!ghs.containsKey(ch) || ghs.get(ch) != hs.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings2("aaaa", "aaaa"));
    }
}