package problemsolvingIII;

import java.util.HashMap;

public class RearrangeCharacterstoMakeTargetString {
    static void main() {
        System.out.println(rearrangeCharactersFast("",""));
    }

    public static int rearrangeCharactersFast(String s, String target) {
        int ans = s.length();
        int[] countS = new int[128];
        int[] countT = new int[128];
        for (final char c : s.toCharArray())
            ++countS[c];
        for (final char c : target.toCharArray())
            ++countT[c];
        for (final char c : target.toCharArray())
            ans = Math.min(ans, countS[c] / countT[c]);
        return ans;
    }

    public int rearrangeCharacters(String text, String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> t = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int max = text.length();
        for (char c : str.toCharArray()) {
            t.put(c, t.getOrDefault(c, 0) + 1);
        }
        for (char c : str.toCharArray()) {
            max = Math.min(max, freq.getOrDefault(c, 0) / t.getOrDefault(c, 1));
        }
        return max;
    }
}
