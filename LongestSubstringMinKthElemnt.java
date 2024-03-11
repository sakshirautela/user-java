import java.util.*;

public class LongestSubstringMinKthElemnt {
    public static int longestSubstring(String s, int k) {
        int len = 0;
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(freq, 0);
            int end = i;
            int f = 0;
            int z=0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(freq[ch-'a']==0){
                    z++;
                }
                if(freq[ch-'a']<k){
                    f++;
                }
                freq[ch - 'a'] = freq[ch - 'a'] + 1;
                if(f>=z*k){
                    end = j;
                }
                System.out.println(f+" "+z);
            }
            System.out.println();
            len = Math.max(len, end - i + 1);
            if(end==s.length()-1) break;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("weitong", 2));
    }
}