public class MinimumNumberOfInsertionOrDeletionToMakeStr1EqualToStr2
{
	public static int minOperations(String str1, String str2) 
	{ 
        // Your code goes here
        //return isSafe(str1,str2,0,0,0);
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill dp array based on LCS logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of LCS
        int lcsLength = dp[n][m];

        // Minimum operations = deletions + insertions
        int deletions = n - lcsLength;
        int insertions = m - lcsLength;

        return deletions + insertions;
	} 
    // private static int isSafe(String str1, String str2, int i, int j, int op) {
    //     if(i==str1.length() && j==str2.length()){
    //         return op;
    //     }
    //     if(i==str1.length() || j==str2.length()){
    //         return Integer.MAX_VALUE;
    //     }
    //     int a=isSafe(str1,str2,i+1,j,op+1);op--;
    //     int b=isSafe(str1,str2,i+1,j+1,op+1);op--;
    //     return Math.min(a,b);
    // }
    public static void main(String arga[]) {
        System.out.println(minOperations("heap", "pea"));
    }
}