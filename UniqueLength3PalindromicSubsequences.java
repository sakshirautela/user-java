import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
    }

    public static int countPalindromicSubsequence(String s) {
        // HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        // for (char ch:s.toCharArray()) {
        //     hm.put(ch,hm.getOrDefault(ch,0)+1);
        // }
        // int n=s.length();
        // System.out.println(hm);
        // int result=0;
        // for (int i = 0; i < n-1; i++) {
        //     char ch=s.charAt(i);
        //     hm.put(ch,hm.getOrDefault(ch,0)-1);
        //     if(hm.get(ch)>=2 && ch==s.charAt(i+1)){
        //         result+=hm.get(ch);
        //     }else if(hm.get(ch)>=1 && ch!=s.charAt(i+1)){
        //         result+=hm.get(ch);
        //     }
        // }
        // return result;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }
            
            last[curr] = i;
        }
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }
            
            Set<Character> between = new HashSet();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }
            
            ans += between.size();
        }
        
        return ans;
    }
    }
}