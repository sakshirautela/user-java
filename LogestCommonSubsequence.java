import java.util.Arrays;

public class LogestCommonSubsequence {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(tabulization(str1, str2));
        System.out.println(memoization(str1, str2, str1.length(), str2.length(),dp));
        System.out.println(longestCommonSubsequence(str1,str2,str1.length(),str2.length()));
    } 
    public static int longestCommonSubsequence(String str1,String str2,int n,int m){
        if(str1=="" || str2=="" || n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return 1+longestCommonSubsequence(str1,str2,n-1,m-1);
        }
        else{
            return Math.max(longestCommonSubsequence(str1,str2,n-1,m),longestCommonSubsequence(str1,str2,n,m-1));
        }
    }
    public static int memoization(String str1,String str2,int n,int m,int dp[][]){
        if(str1=="" || str2=="" || n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m]=1+memoization(str1,str2,n-1,m-1,dp);
        }
        else{
            return dp[n][m]=Math.max(memoization(str1,str2,n-1,m,dp),memoization(str1,str2,n,m-1,dp));
        }
    }
    public static int tabulization(String str1,String str2){
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            dp[i][0]=0;
        }for(int i=0;i<str2.length()+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
