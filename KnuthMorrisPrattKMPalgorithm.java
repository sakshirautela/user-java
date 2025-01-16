public class KnuthMorrisPrattKMPalgorithm {
    public static void main(String[] args) {
        System.out.println(areRotations("abc", "aba"));
    }

    public static boolean areRotations(String s1, String s2) {

        String txt = s1 + s1;
        String pat = s2;

        // search the pattern string s2 in the concatenation string
        int n = txt.length();
        int m = pat.length();

        // Create lps[] that will hold the longest prefix suffix
        // values for pattern
        int[] lps = computeLPSArray(pat);

        int i = 0;
        int j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == m) {
                return true;
            }

            // Mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {

                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

}
