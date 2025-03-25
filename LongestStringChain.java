// Java code for Longest String Chain
// using DP + Hashing
import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {
    
    public static int longestStringChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int res = 1;
        for (String w : words) {
            dp.put(w, 1); // Initialize length for current word
            
            for (int i = 0; i < w.length(); i++) {
                String pred = w.substring(0, i) + w.substring(i + 1);
                if (dp.containsKey(pred)) {
                    dp.put(w, Math.max(dp.get(w), dp.get(pred) + 1));
                }
            }
            
            res = Math.max(res, dp.get(w));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStringChain(words));
    }
}
