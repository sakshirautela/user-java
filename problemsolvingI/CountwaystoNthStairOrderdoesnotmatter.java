
public class CountwaystoNthStairOrderdoesnotmatter {
    public static int nthStair(int n) {
        // Code here
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+1;
        }
        return dp[n];
    }
    int nthStair2(int n){
        //  Code here
        
        return n/2 + 1;
    }
    public static void main(String[] args) {
        System.out.println(nthStair(5));

    }


}
