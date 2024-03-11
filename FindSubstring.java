import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class FindSubstring {
    // static boolean helper(String s,HashMap<String,Integer> hs,int e ) {
    // HashMap<String,Integer> temp=new HashMap<String,Integer>();
    // for(String str : hs.keySet()){
    // temp.put(str,hs.get(str));
    // }
    // int start=0;
    // int end=e;
    // while (end <= s.length()) {
    // if (!temp.containsKey(s.substring(start, end))) {
    // return false;
    // }
    // else{
    // temp.put(s.substring(start, end),temp.get(s.substring(start, end))-1);
    // if(temp.get(s.substring(start, end))==0){
    // temp.remove(s.substring(start, end));
    // }
    // }
    // start=start+e;
    // end=end+e;
    // }
    // return true;
    // }
    // public static List<Integer> findSubstring(String s, String[] words) {
    // List<Integer> res = new ArrayList<Integer>();
    // HashMap<String,Integer> hs = new HashMap<>();
    // for (int i = 0; i < words.length; i++) {
    // hs.put(words[i],hs.getOrDefault(words[i],0)+1);
    // }
    // int start = 0;
    // int end = words[0].length() * words.length ;
    // while (start<end && end <= s.length()) {
    // if (helper(s.substring(start, end),hs,words[0].length())) {
    // res.add(start);
    // }

    // start=start+words[0].length();
    // end+=words[0].length();
    // }
    // return res;

    // }
    // static boolean helper(String s,HashMap<String,Integer> hs,int e ) {
    // HashMap<String,Integer> temp=new HashMap<String,Integer>();
    // for(String str : hs.keySet()){
    // temp.put(str,hs.get(str));
    // }
    // int start=0;
    // int end=e;
    // while (end <= s.length()) {
    // if (!temp.containsKey(s.substring(start, end))) {
    // return false;
    // }
    // else{
    // temp.put(s.substring(start, end),temp.get(s.substring(start, end))-1);
    // if(temp.get(s.substring(start, end))==0){
    // temp.remove(s.substring(start, end));
    // }
    // }
    // start=start+e;
    // end=end+e;
    // }
    // return true;
    // }
    // public static List<Integer> findSubstring2(String s, String[] words) {
    // List<Integer> res = new ArrayList<Integer>();
    // HashMap<String,Integer> hs = new HashMap<>();
    // for (int i = 0; i < words.length; i++) {
    // hs.put(words[i],hs.getOrDefault(words[i],0)+1);
    // }
    // System.out.println(hs);
    // int start = 0;
    // int end = words[0].length() * words.length ;
    // while (end <= s.length()) {
    // if (helper(s.substring(start, end),hs,words[0].length())) {
    // res.add(start);
    // }

    // start++;
    // end++;
    // }
    // return res;

    // }

    static boolean helper(String s, HashMap<String, Integer> hs, int e) {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        for (String str : hs.keySet()) {
            temp.put(str, hs.get(str));
        }
        int start = 0;
        int end = e;
        while (end <= s.length()) {
            if (!temp.containsKey(s.substring(start, end))) {
                return false;
            } else {
                temp.put(s.substring(start, end), temp.get(s.substring(start, end)) - 1);
                if (temp.get(s.substring(start, end)) == 0) {
                    temp.remove(s.substring(start, end));
                }
            }
            start = start + e;
            end = end + e;
        }
        return true;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hs.put(words[i], hs.getOrDefault(words[i], 0) + 1);
        }
        int start = 0;
        int end = words[0].length() * words.length;
        while (start < end && end <= s.length()) {
            if (helper(s.substring(start, end), hs, words[0].length())) {
                res.add(start);
            }

            start = start + words[0].length();
            end += words[0].length();
        }
        return res;
    }

    
    class Solution {
        static boolean helper(String s, HashMap<String, Integer> hs, int e) {
            HashMap<String, Integer> temp = new HashMap<String, Integer>();
            for (String str : hs.keySet()) {
                temp.put(str, hs.get(str));
            }
            int start = 0;
            int end = e;
            while (end <= s.length()) {
                if (!temp.containsKey(s.substring(start, end))) {
                    return false;
                } else {
                    temp.put(s.substring(start, end), temp.get(s.substring(start, end)) - 1);
                    if (temp.get(s.substring(start, end)) == 0) {
                        temp.remove(s.substring(start, end));
                    }
                }
                start = start + e;
                end = end + e;
            }
            return true;
        }
        
        public static List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            HashMap<String, Integer> hs = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                hs.put(words[i], hs.getOrDefault(words[i], 0) + 1);
            }
            int start = 0;
            int end = words[0].length() * words.length;
            while (start < end && end <= s.length()) {
                if (helper(s.substring(start, end), hs, words[0].length())) {
                    res.add(start);
                }
                
                start = start + words[0].length();
                end += words[0].length();
            }
            return res;
            
        }
        
    }
    public static List<Integer> findSubstring3(String s, String[] words){
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i],hm.getOrDefault(words[i], 0)+1);
        }
        List<Integer> res = new ArrayList<Integer>();
        int m=words.length;
        int n=words[0].length();
        for (int i = 0; i <= s.length()-m*n; i++) {
            HashMap<String, Integer> t = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                int startingIdx= i+j*n;    
                String str=s.substring(startingIdx, startingIdx+n);
                if(!hm.containsKey(str)){
                    break;
                }
                t.put(str,t.getOrDefault(str,0)+1);
                if(t.get(str)>hm.getOrDefault(str, 0)){
                    break;
                }
                if(j+1==m){
                    res.add(i);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] words = { "word", "good", "best", "good"};
        System.out.println(findSubstring3("wordgoodgoodgoodbestword", words));

    }
}