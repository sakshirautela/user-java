package problemsolvingIII;

import java.util.HashSet;

public class AnagramPalindrome {
    static void main() {
        System.out.println();
    }

    static boolean canFormPalindrome(String s) {
        // code here
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return (set.size() == 1 || set.isEmpty());
    }
}