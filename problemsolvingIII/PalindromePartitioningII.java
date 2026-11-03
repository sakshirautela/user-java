package problemsolvingIII;

public class PalindromePartitioningII {
    static void main() {
        System.out.println();
    }
        public int minCut(String s) {
            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j) &&
                            (j - i <= 2 || isPalindrome[i + 1][j - 1])) {

                        isPalindrome[i][j] = true;
                    }
                }
            }
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                if(isPalindrome[0][i]){
                    dp[i] = 0;
                }else{
                    dp[i]=i;
                    for(int j=0;j<i;j++){
                        if(isPalindrome[j+1][i]){
                            dp[i] = Math.min(dp[i],dp[j]+1);
                        }
                    }
                }
            }
            return dp[n-1];
    }
}
