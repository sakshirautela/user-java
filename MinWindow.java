import java.util.*;

class MinWindow {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hs.put(t.charAt(i), hs.getOrDefault(t.charAt(i), 0) + 1);
        }
        int end = 0;
        int start = 0;
        String result = "";
        String str = "";
        while (end < s.length()) {
            char ch = s.charAt(end);
            str += ch;
            temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            end++;
            if (isEquals(temp, hs)) {
                System.out.println("yess");
                result = (str.length() < result.length() || result == "") ? str : result;
                start++;
                end = start;
                temp = new HashMap<>();
                str = "";
            }
        }
        return result;
    }

    private static boolean isEquals(HashMap<Character, Integer> temp, HashMap<Character, Integer> hs) {
        for (char ch : hs.keySet()) {
            if (!temp.containsKey(ch)){
                return false;
            }
            else if(temp.containsKey(ch) && temp.get(ch) != hs.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindowII("ADOBECODEBANC", "ABC"));
    }
    public static String minWindowII(String s, String t) {
        int n=t.length();
        if(s.length()<n) return "";
        int track[]=new int[128];
        for(char c:t.toCharArray()){
            track[c]++;
        }
        int startIdx=-1,count=n,len=Integer.MAX_VALUE,left=0,right=0;
        char[] sArrays=s.toCharArray();
        while(left<sArrays.length){
            if(track[sArrays[left++]]-- >0){
                count--;
            }
            while(count==0){
                if(left-right<len){
                    len=left-right;
                    startIdx=right;
                }
                if(track[sArrays[right++]]++ ==0){
                    count++;
                }
            }
        }
        return (len!=Integer.MAX_VALUE?new String(sArrays,startIdx,len):"");
    }

}