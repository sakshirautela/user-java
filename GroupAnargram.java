import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class GroupAnargram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            if (hm.containsKey(a)) {
                if (hm.get(a) > 1) {
                    hm.put(a, hm.getOrDefault(a, 0) - 1);
                } else {
                    hm.remove(a);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList();
        HashMap<String ,Integer>hm=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            hm.put(strs[i],1);
        }
        for (int i = 0; i < strs.length; i++){
            if(hm.containsKey(strs[i])){
                List<String> temp = new ArrayList();
                temp.add(strs[i]);
                hm.remove(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram(strs[i], strs[j])) {
                        temp.add(strs[j]);
                        hm.remove(strs[j]);
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

    }
}
