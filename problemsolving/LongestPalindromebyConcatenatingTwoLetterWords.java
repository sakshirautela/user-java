import java.util.HashMap;

public class LongestPalindromebyConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[] { "lc", "cl", "gg" }));
    }
    private static final int S = 5;
    private static final int M = (1 << S) - 1;
    static {
        for(int i = 0; i < 100; i++) {
            longestPalindrome(new String[]{"lc", "cl", "gg"});
        }
    }
    public static int longestPalindrome(String[] words) {
        int[] freq = new int[1 << (S << 1)];
        for (String s: words)
            freq[(s.charAt(0) & M) << S | s.charAt(1) & M]++;
        int res = 0, mid = 0;
        for (int i = 1; i <= 26; i++) {
            int dupe = freq[i << S | i];
            res += dupe >> 1;
            mid |= dupe & 1;
            for (int j = i + 1; j <= 26; j++) {
                res += Math.min(freq[i << S | j], freq[j << S | i]);
            }
        }
        return (res << 2) | (mid << 1);
    }
    public static int longestPalindrome2(String[] words) {
        int res = 0;
        HashMap<String, Integer> freq = new HashMap<>();
        for (String string : words) {
            freq.put(string, freq.getOrDefault(string, 0) + 1);
        }
        boolean isCentered = false;
        for (String string : words) {
            int f=freq.get(string);
            String rev = new StringBuilder(string).reverse().toString();
            if(string.equals(rev)){
                res+=f/2*4;
                if(f%2==1){
                    isCentered=true;
                }
            }else if (freq.containsKey(rev)) {
                res+=Math.min(f,freq.get(rev))*4;
                freq.put(rev,0);
            }
                freq.put(string,0);

        }
        if(isCentered){
            res+=2;
        }
        return res;
    }
}