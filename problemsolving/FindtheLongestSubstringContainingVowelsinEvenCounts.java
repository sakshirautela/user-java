
import java.util.*;
public class FindtheLongestSubstringContainingVowelsinEvenCounts {
    public static int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int cnt = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                cnt ^= (1 << ((int)(s.charAt(i) - 'a')));
            }
            if (mp.containsKey(cnt)) {
                ans = Math.max(ans, i - mp.get(cnt));
            } else {
                mp.put(cnt, i);
            }
        }
        return ans;
    }
    public static void main(String atgs[]){
        System.out.println(findTheLongestSubstring("abscss"));
    }
}
