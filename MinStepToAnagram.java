import java.util.HashMap;

public class MinStepToAnagram {
    public static int minSteps(String s, String t) {
        HashMap<Character,Integer> hs=new HashMap<>();
        HashMap<Character,Integer> ht=new HashMap<>();
        for(char ch:s.toCharArray()){
            hs.put(ch,hs.getOrDefault(ch, 0)+1);
        }
        for(char ch:t.toCharArray()){
            ht.put(ch,ht.getOrDefault(ch, 0)+1);
        }
        int diff=0;
        System.out.println(hs);        
        System.out.println(ht);
        for(char ch:hs.keySet()){
            if(ht.containsKey(ch) && hs.get(ch)>ht.get(ch)){
                diff+=(hs.get(ch)-ht.get(ch));
            }else if(!ht.containsKey(ch)){
                diff+=hs.get(ch);
            }
        }
        return diff;
    }
    public static int minSteps2(String s, String t) {
        int[] count=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            count[ch-'a']--;
        }
        int res=0;;
        for(int i:count){
            if(i>0) res+=i;
        }
        return res;
    }
    public static void main(String[] args) {
        System.err.println(minSteps2("leetcode", "practice"));
    }
}