public class WildCardMatching {
    public static void main(String[] args) {
        String pattern="?*?";
        String str="b";
        System.out.println(wildCardMatching(pattern,str));
    }
    public static boolean wildCardMatching(String pattern,String str){
        int n=str.length();
        int m=pattern.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        for (int j = 1; j < m + 1; j++) {
            // if(str.charAt(0)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
            //         dp[0][j]=dp[0][j-1];
            // }
            // else if(pattern.charAt(j-1)=='*'){
            //     dp[0][j]=dp[0][j] || dp[0][j-1];
            // }
            // else{
            //     dp[0][j]=false;
            // }   
            if(pattern.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }      
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pattern.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        printdp(dp);
        return dp[n][m];
    }
    private static void printdp(boolean[][] dp) {
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
