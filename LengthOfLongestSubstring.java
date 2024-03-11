import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        String str = "";
        int len = 0;
        int start = 0;
        int end = 0;
        int flag = -1;
        while (end < s.length()) {
            if (!hm.containsKey(s.charAt(end))) {
                str = s.substring(start, end + 1);
                hm.put(s.charAt(end), end);
                end++;
            } else if (hm.containsKey(s.charAt(end)) && (flag) == -1) {
                flag = (hm.get(s.charAt(end)));
                len = Math.max(len, str.length());
                start = hm.get(s.charAt(end)) + 1;
                hm.put(s.charAt(end), end);
                end++;
            } else if (hm.containsKey(s.charAt(end)) && flag != -1) {
                if (hm.get(s.charAt(end)) > flag) {
                    flag = (hm.get(s.charAt(end)));
                    len = Math.max(len, str.length());
                    start = hm.get(s.charAt(end)) + 1;
                    hm.put(s.charAt(end), end);
                    end++;
                } else {
                    str = s.substring(start, end + 1);
                    hm.put(s.charAt(end), end);
                    end++;
                }
            }
        }
        return Math.max(len, str.length());
    }
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> ss = new HashSet<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            while (ss.contains(c)) {
                ss.remove(s.charAt(i++));
            }
            ss.add(c);
            ans = Math.max(ans, j - i + 1);
        }
        System.out.println(ss);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));        
        System.out.println(lengthOfLongestSubstring2("tmmzuxt"));

    }
}