public class PaintingtheFence {
    static void main() {
        System.out.println(countWaysNoExtraSpace(3,2));
    }
    static int countWaysNoExtraSpace(int n, int k) {
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        int e=k*k;
        int o=k;
        int res=o;
        for(int i=3;i<=n;i++){
            res=e*(k-1)+o*(k-1);
            o=e;
            e=res;
        }
        return res;
    }
        static int countWays(int n, int k) {
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        int[] dp=new int[n+1];
        dp[1]=k;
        dp[2]=k*k;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]*(k-1))+(dp[i-2]*(k-1));
        }
        return dp[n];
    }
        static int countWaysTLE(int n, int k) {
        // code here.
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        return (countWays(n-1,k)*(k-1))+(countWays(n-2,k)*(k-1));
    }
}
