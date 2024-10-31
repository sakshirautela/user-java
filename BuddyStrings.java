import java.util.*;

public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        if ((s.length() != goal.length())) {
            return false;
        }
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        // HashMap<Character,Integer> rev=new HashMap<Character,Integer>();
        int equal = 0;
        for (int i = 0; i < n; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            freq.put(goal.charAt(i), freq.getOrDefault(goal.charAt(i), 0) - 1);
            if (s.charAt(i) != goal.charAt(i)) {
                equal++;
                if (equal > 2) {
                    return false;
                }
            }
        }
        for (int i : freq.values()) {
            if (i != 0) {
                return false;
            }
        }
        if (freq.size() == n && equal != 2) {
            return false;
        }
        return true;
    }

    public boolean buddyStrings2(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (!set.add(c)) {
                    return true;
                }
            }
            return false;
        } else {
            int n = s.length();
            char[] ch = s.toCharArray();
            char[] sh = goal.toCharArray();
            int f = -1;
            int se = -1;
            for (int i = 0; i < n; i++) {
                if (ch[i] != sh[i]) {
                    if (f == -1) {
                        f = i;
                    } else if (se == -1) {
                        se = i;
                    } else {
                        return false;
                    }
                }
            }

            if (se != -1 && s.charAt(f) == goal.charAt(se) && goal.charAt(f) == s.charAt(se)) {
                return true;
            }
        }
        return false;
    }

    public boolean buddyStrings3(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            // abcd abcd
            // aabc aabc
            // we already know both strings are equal so now we only check for repeat
            // characters
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstIndex == -1) { // something would differ
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                } else {
                    return false;
                }
            }
        }
        if (secondIndex == -1) {
            return false;
        }
        // now we should check if the two characters are interchangeable
        return s.charAt(firstIndex) == goal.charAt(secondIndex) &&
                s.charAt(secondIndex) == goal.charAt(firstIndex);
    }
    // Time = O(n)
    // Space = O(1)

    public static void main(String[] args) {
        System.out.println(buddyStrings("abcaa", "abcbb"));
    }
}