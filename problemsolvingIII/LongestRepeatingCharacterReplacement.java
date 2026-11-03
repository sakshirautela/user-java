package problemsolvingIII;

import java.util.HashMap;
import java.util.TreeMap;

public class LongestRepeatingCharacterReplacement {
    static void main() {
        System.out.println(longestSubstr("ADBD",1));
    }
    public static int longestSubstr(String s, int k) {
        // code here
        int n = s.length();
        int[] freq=new int[26];
        char[] ch=s.toCharArray();
        int i=0;
        int result=0;
        int max=0;
        for(int j=0;j<n;j++){
            freq[ch[j]-'a']++;
            max=Math.max(max,freq[ch[j]-'a']);
            while ((j-i+1)-max>k){
                freq[ch[i]-'a']--;
                i++;
            }
            result=Math.max(result,j-i+1);
        }
        return result;
    }
}
