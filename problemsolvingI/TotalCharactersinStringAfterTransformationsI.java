import java.util.HashMap;

public class TotalCharactersinStringAfterTransformationsI {
    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("",3));
    }
    static char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    @SuppressWarnings("unused")
    public static int lengthAfterTransformations(String s, int t) {
        int n=s.length();
        int result=0;
        HashMap<Character,Integer> freq=new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch,freq.getOrDefault(ch, 0)+1);
        }
        return result=0;
    }
    public int lengthAfterTransformations2(String s, int t) {
    	int MOD = (int)1e9 + 7, ans = 0;
        long[] count = new long[26];
        for (int c : s.toCharArray())
        	count[c - 'a']++;
        for (; t >= 26; t -= 26) {
        	long z = count[25];
        	for (int i = 25; i > 0; i--)
        		count[i] = (count[i] + count[i - 1]) % MOD;
        	count[0] = (count[0] + z) % MOD;
        	count[1] = (count[1] + z) % MOD;
        }
        for (int i = 0; i < 26; i++)
        	ans = (int)((ans + count[i]) % MOD);
        for (int i = 26 - t; i < 26; i++)
        	ans = (int)((ans + count[i]) % MOD);
        return ans;
    }
}