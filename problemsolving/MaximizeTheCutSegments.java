
import java.util.Arrays;

public class MaximizeTheCutSegments{
    public static int maximizeCuts(int n, int x, int y, int z, int[] dp)
    {
       //Your code here
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
                return dp[n];
        }
        int a=Integer.MIN_VALUE;
        int b=a,c=a;
        if(x<=n){
                a=maximizeCuts(n-x,x,y,z,dp);
        }
        if(y<=n){
            b=maximizeCuts(n-y,x,y,z,dp);
        }
            if(z<=n){
                c=maximizeCuts(n-z,x,y,z,dp);
            }
        return dp[n]=Math.max(a,Math.max(b,c))+1;
    }
    public static void main(String args[]){
        int n=68;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(maximizeCuts(n,11,49,70,dp));//res<0 return 0
    }
}
