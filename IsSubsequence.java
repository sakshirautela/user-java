import java.util.HashMap;

class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i=0;        
        int j=0;
        String res="";
        while (i<t.length() && j<s.length()) {
            if(t.charAt(i)==s.charAt(j)){
                res+=s.charAt(j);
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(res.equals(s)){
            return true;
        }
        else{
            return false;
        } 
    }
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}