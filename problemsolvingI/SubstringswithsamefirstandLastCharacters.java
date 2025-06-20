public class SubstringswithsamefirstandLastCharacters {
    public static void main(String[] args) {
        System.out.println(countSubstring(""));
    }
    public static int countSubstring(String s) {
        // code here
        int result=0;
        int[] freq=new int[26];
        for (char  ch : s.toCharArray()) {
            freq[ch-'a']++;
            result+=freq[ch-'a'];
        }
        return  result;
    }
}