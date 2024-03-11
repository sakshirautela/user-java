public class WildCardMatching {
    public static void main(String[] args) {
        String str1="mississippi";
        String str2="m??*ss*?i*pi";
        System.out.println(wildCardMatching(str1,str2));
    }
    public static boolean wildCardMatching(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        for (int j = 1; j < m + 1; j++) {
            // if(s1.charAt(0)==s2.charAt(j-1) || s2.charAt(j-1)=='?'){
            //         dp[0][j]=dp[0][j-1];
            // }
            // else if(s2.charAt(j-1)=='*'){
            //     dp[0][j]=dp[0][j] || dp[0][j-1];
            // }
            // else{
            //     dp[0][j]=false;
            // }   
            if(s2.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }      
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(s2.charAt(j-1)=='*'){
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
