
public class LongestPalindromeinaString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }

    static String longestPalindrome(String s) {
        // code here
        int n = s.length();
        int result = -1;
        String str="";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    result = Math.max(result, j - i + 1);
                    str=s.substring(i,j+1);
                }
            }
        }
        return str;
    }

    private static boolean isPalindrome(int i, int j, String s) {
        while (i<j) {
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
