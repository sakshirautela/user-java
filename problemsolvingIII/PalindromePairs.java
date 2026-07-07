package problemsolvingIII;

import java.util.*;

public class PalindromePairs {
    static void main() {
        System.out.println(palindromePair(new String[]{"geekf", "geeks", "or", "keeg", "abc", "bc"}));
    }
    public static boolean palindromePair(String[] arr) {
        // Code here
        HashMap<String, Integer> rev = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            String r=new StringBuilder(arr[i]).reverse().toString();
            rev.put(r, i);
        }
        for(int i = 0; i < arr.length; i++){
            String c=arr[i];
            String l="";  //y
            for(int j = 0; j < c.length(); j++){
                l+=c.charAt(j); //x  -> rev(s)==x - x+y+x palindrome if y is palindrom
                String r=c.substring(j+1);
                if(palindrome(l)&& rev.containsKey(r) && rev.get(r)!=i){
                    return true;
                }
                if(palindrome(r)&& rev.containsKey(l) && rev.get(l)!=i){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean palindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}