import java.util.*;

class FindPermutationString {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> hm=new HashMap();
        for(char c:s1.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        boolean found=false;
        System.out.println(hm);
        int n=s1.length();
        for(int i=0;i<=s2.length()-s1.length();i++){
            HashMap<Character,Integer> temp=new HashMap();
            for(int j=i;j<i+s1.length();j++){
                char ch=s2.charAt(j);
                if(hm.containsKey(ch)){
                    temp.put(ch,temp.getOrDefault(ch,0)+1);
                }
                if(!hm.containsKey(ch)){
                    break;
                }
                if(hm.get(ch)<temp.get(ch)){
                    break;
                }
                if(j==i+n-1){
                    found= true;
                    break;
                }
            }
            if(found){
                break;
            }
            System.out.println(temp);
        }
        return found;
    }
    public static void main(String[] args){
        System.out.println(checkInclusion("adc", "dcda"));
    }
    public boolean checkInclusion2(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] refCnts = getReferenceCounts(s1);
        int i = 0;
        while (i <= s2.length()-s1.length()) {
            if (refCnts[s2.charAt(i)-'a'] > 0) {
                int ni = _checkInclusion(s1, s2, i);
                if (ni < 0) return true;
                i = ni;
            } else {
                i++;
            }
        }
        return false;
    }

    public int[] getReferenceCounts(String s) {
        int[] refCnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            refCnts[s.charAt(i)-'a']++;
        }
        return refCnts;
    }

    public int _checkInclusion(String s1, String s2, int i) {
        int[] refCnts = getReferenceCounts(s1);
        for (int j = i+s1.length()-1; j >= i; j--) {
            if (refCnts[s2.charAt(j)-'a'] == 0) {
                return j+1;
            }
            refCnts[s2.charAt(j)-'a']--;
        }
        for (int j = i; j < i+s1.length(); j++) {
            if (refCnts[s2.charAt(j)-'a'] > 0 || refCnts[s2.charAt(j)-'a'] < 0) {
                return j;
            }
        }
        return -1;
    }
}