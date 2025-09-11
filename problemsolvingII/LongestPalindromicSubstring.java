public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int n=s.length();
        int ans=0;
        String res="";
        for (int i = 0; i <n ; i++) {
            int l=i,r=i;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if (ans < (r - l - 1)) {
                ans = r - l - 1;
                res = s.substring(l + 1, r);
            }
            l=i-1;
            r=i;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if (ans < (r - l - 1)) {
                ans = r - l - 1;
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }
}
