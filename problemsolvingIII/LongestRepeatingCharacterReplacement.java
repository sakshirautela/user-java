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
        int i=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int result=0;
        for(int idx=0;idx<n;idx++){
            char c=s.charAt(idx);
            map.put(c,map.getOrDefault(c,0)+1);
            max = Math.max(max,map.get(c));
            while (i<n && idx-i-max+1>k){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            result=Math.max(result,idx-i+1);
        }
        return result;
    }
}
