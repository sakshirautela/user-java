import java.util.HashMap;

public class SubstringsoflengthKwithKminius1istinctElements {
    public static void main(String[] args) {
        System.out.println(substrCount("abcc", 2));
    }

    public static int substrCount(String s, int k) {
        // code here
        int n = s.length();
        char ch[] = s.toCharArray();
        int result = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put(ch[i], freq.getOrDefault(ch[i], 0) + 1);
        }
        if (freq.size() == k - 1) {
            result++;
        }
        for (int i = k; i < n; i++) {
            freq.put(ch[i], freq.getOrDefault(ch[i], 0) + 1);
            freq.put(ch[i - k], freq.getOrDefault(ch[i - k], 0)- 1);
            if (freq.get(ch[i - k]) == 0) {
                freq.remove(ch[i - k]);
            }
            if (freq.size() == k - 1) {
                result++;
            }
        }
        return result;
    }
}