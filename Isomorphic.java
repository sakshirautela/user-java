import java.util.HashMap;
import java.util.HashSet;

import java.util.HashMap;

public class Isomorphic {
    public static void main(String[] args) {
        String s="foo",t="baa";
        HashMap<Character, Character> replacement = new HashMap<>();
        HashMap<Character, Boolean> used = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (replacement.containsKey(s.charAt(i))) {
                if (replacement.get(s.charAt(i)) != t.charAt(i)){
                    System.out.print("not");
                }
            } else {
                if (used.containsKey(t.charAt(i)))
                    System.out.print("not");
                replacement.put(s.charAt(i), t.charAt(i));
                used.put(t.charAt(i), true);
            }
        }
        System.out.print("yes");
    }
}
