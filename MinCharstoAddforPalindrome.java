public class MinCharstoAddforPalindrome {
    public static int minChar(String s) {
        // Write your code here
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0 && !isPalindrome(s, 0, i)) {
            i--;
            count++;
        }
        return count;

    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            
            // If characters at the ends are not the same, it's not a palindrome
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];

        // lps[0] is always 0
        lps[0] = 0;
        int len = 0;

        // loop calculates lps[i] for i = 1 to n-1
        int i = 1;
        while (i < n) {

            // If the characters match, increment len
            // and set lps[i]
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            // If there is a mismatch
            else {

                // If len is not zero, update len to
                // the last known prefix length
                if (len != 0) {
                    len = lps[len - 1];
                }

                // No prefix matches, set lps[i] to 0
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Method returns minimum character to be added at
    // front to make string palindrome
    static int minChar2(String s) {
        int n = s.length();
        String rev
            = new StringBuilder(s).reverse().toString();

        // Get concatenation of string, special character
        // and reverse string
        s = s + "$" + rev;

        // Get LPS array of this concatenated string
        int[] lps = computeLPSArray(s);

        // By subtracting last entry of lps array from
        // string length, we will get our result
        return (n - lps[lps.length - 1]);
    }
    // User function Template for Java

    public static int minChar3(String A) {
        String rev = new StringBuilder(A).reverse().toString();
        String concat = A + "$" + rev;
        int[] lps = new int[concat.length()];
        int y = 0;
        for (int x = 1; x < concat.length(); x++) {
            while (y > 0 && concat.charAt(x) != concat.charAt(y)) {
                y = lps[y - 1];
            }
            if (concat.charAt(x) == concat.charAt(y)) {
                y++;
            }
            lps[x] = y;
        }
        return A.length() - lps[concat.length() - 1];
    }
    public static void main(String args[]) {
        System.out.println(minChar("ab"));
    }
}