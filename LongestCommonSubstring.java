public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="abcce";
        System.out.println(tabulization(str1,str2));
    }
    public static int tabulization(String str1,String str2){
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++){
            dp[i][0]=0;
        }for(int i=0;i<str2.length()+1;i++){
            dp[0][i]=0;
        }
        int ans=0;
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}
