import java.util.HashMap;
import java.util.Objects;

class WordPattern {
    // public static boolean wordPattern(String p, String s) {
    //     HashMap<String, Character> b = new HashMap<>();
    //     HashMap<Character, String> f = new HashMap<>();
    //     int idx = 0;
    //     String res = "";
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if (ch == ' ' && idx < p.length()) {
    //             if (!b.containsKey(res) && !f.containsKey(p.charAt(idx))) {
    //                 b.put(res, p.charAt(idx));
    //                 f.put(p.charAt(idx), res);
    //             } else if ((b.containsKey(res) && !f.containsKey(p.charAt(idx)))
    //                     || !(b.containsKey(res) && f.containsKey(p.charAt(idx)))) {
    //                 return false;
    //             } else if (b.get(res) != p.charAt(idx) || !f.get(p.charAt(idx)).equals(res)) {
    //                 return false;
    //             }
    //             idx++;
    //             res = "";
    //         } else {
    //             res += ch;
    //         }
    //     }
    //     if (idx == p.length() - 1) {
    //         if (!b.containsKey(res) && !f.containsKey(p.charAt(idx))) {
    //             b.put(res, p.charAt(idx));
    //             f.put(p.charAt(idx), res);
    //         } else if ((b.containsKey(res) && !f.containsKey(p.charAt(idx)))
    //                 || !(b.containsKey(res) && f.containsKey(p.charAt(idx)))) {
    //             return false;
    //         } else if (b.get(res) != p.charAt(idx) || !f.get(p.charAt(idx)).equals(res)) {
    //             return false;
    //         }
    //     }
        
    //     if(idx>=p.length() || idx<p.length()-1) {
    //         return false;
    //     }
        
    //     if (f.size() != b.size()) {
    //         return false;
    //     }
    //     return true;
    // }
    public static boolean wordPattern(String p, String s) {
        String[] word=s.split(" ");
        if(word.length != p.length()) {
            return false;
        }
        HashMap<String, Integer> b = new HashMap<>();
        HashMap<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            if(!Objects.equals(b.put(word[i], i),f.put(p.charAt(i), i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaa", "aa aa aa"));
    }
}