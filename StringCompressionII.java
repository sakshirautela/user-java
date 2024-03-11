import java.util.Arrays;

public class StringCompressionII {
    public static int getLengthOfOptimalCompression(String s, int k) {
        int len=s.length();
        char[] c = s.toCharArray();
        int dp[][]=new int[len+1][k+1];
        for(int i=0; i<len+1; i++){
            Arrays.fill(dp[i],1100);
        }
        dp[0][0]=0;
        for (int i = 1; i <=len;i++) {
            for (int j = 0; j<=k;j++){
                int ch=c[i-1];
                int del=0;
                int count=0;
                for(int p=i;p>=1;p--){
                    if(ch==c[p-1]){
                        count++;
                    }else{
                        del++;
                    }

                    if(j-del>=0){
                        dp[i][j]=Math.min(dp[i][j],dp[p-1][j-del]+getcount(count));
                    }
                }
                if(j>0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]);
                }
            }
        }
        return dp[len][k];
    }
    private static int getcount(int count) {
        if(count==1){
            return 1;
        }
        if(count<10){
            return 2;
        }
        else if(count<100){
            return 3;
        }
        else{
            return 4;
        }
    }
    public static void main(String[] args) {
        System.out.println(getLengthOfOptimalCompression("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",2));
    }
}