import java.util.Arrays;

public class MinimumDeletions {
    public static void main(String[] args) {
        System.out.println(minDeletions(""));
    }
    static int minDeletions(String s) {
        // code here
        int n=s.length();
        char ch[]=s.toCharArray();
        int[][] dp=new int[n][n];
        return toPalindome(0, n-1, ch,dp);
    }
    private static int toPalindome(int i, int j, char[] ch, int[][] dp) {
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(ch[i]==ch[j]){
            return dp[i][j]=toPalindome(i+1, j-1, ch,dp);
        }
        return dp[i][j]=1+Math.min(toPalindome(i+1, j, ch,dp),toPalindome(i, j-1, ch,dp));
    }
// Java program to find Minimum number of 
// deletions to make a string palindrome 
    // Function to calculate the minimum
    // Element required to delete for
    // Making string palindrome
    static int minDeletions2(String s) {
        int n = s.length();

        // We need 3 arrays: current and two previous rows
        int[] prev1 = new int[n];
        int[] curr = new int[n];
        int[] prev2 = new int[n];

        // Fill the dp table
        // l is the length of substring
        for (int l = 2; l <= n; l++) {

            // Update current row 
            for (int i = n - l; i >= 0; i--) {
                int j = i + l - 1;

                // If there are only 2 characters
                if (l == 2) {
                    curr[i] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
                } 
                else {

                    // If first and last characters match
                    if (s.charAt(i) == s.charAt(j)) {
                        curr[i] = prev2[i + 1];
                    } 
                    else {
                        // If they don't match, consider minimum of two choices
                        curr[i] = 1 + Math.min(prev1[i], prev1[i + 1]);
                    }
                }
            }
            // Update previous with current for next iteration
            prev2 = prev1.clone();
            prev1 = curr.clone();
        }

        // Return minimum deletions for entire string
        return prev1[0];
    }
// Java program to find Minimum number of 
// deletions to make a string palindrome

    // Function to find the length of the lps
    static int longestPalinSubseq(String s) {
        int n = s.length();

        // Create two vectors: one for the current state (dp)
        // and one for the previous state (dpPrev)
        int[] curr = new int[n];
        int[] prev = new int[n];

        // Loop through the string in reverse (starting from the end)
        for (int i = n - 1; i >= 0; --i) {

            // Initialize the current state of dp
            curr[i] = 1;

            // Loop through the characters ahead of i
            for (int j = i + 1; j < n; ++j) {

                // If the characters at i and j are the same
                if (s.charAt(i) == s.charAt(j)) {

                    // Add 2 to the length of the palindrome between them
                    curr[j] = prev[j - 1] + 2;
                } else {

                    // Take the maximum between excluding either i or j
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            // Update previous to the current state of dp
            prev = Arrays.copyOf(curr, n);
        }

        return curr[n - 1];
    }

    // Function to calculate the minimum
    // Element required to delete for
    // Making string palindrome
    static int minDeletions3(String s) {
        int n = s.length();

        // Find the LPS 
        int lps = longestPalinSubseq(s);

        return n - lps;
    }

}