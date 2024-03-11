public class OutOffBoundaryPaths {
    Integer[][][] dp;
    int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int i, int j) {
        dp=new Integer[m][n][maxMove+1];
        return helper(i, j, maxMove, m, n);
    }
    public  int helper(int i, int j, int maxMove,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n){
            return 1;
        } 
        if(maxMove<=0){
            return 0;
        }
        if(dp[i][j][maxMove]!=null){
            return dp[i][j][maxMove];
        }
        int res=0;
        res=(res+helper(i-1,j,maxMove-1,m,n))%mod;
        res=(res+helper(i+1,j,maxMove-1,m,n))%mod;
        res=(res+helper(i,j-1,maxMove-1,m,n))%mod;
        res=(res+helper(i,j+1,maxMove-1,m,n))%mod;
        dp[i][j][maxMove]=res;
        return res;
    }
    public static void main(String[] args) {
        OutOffBoundaryPaths obj = new OutOffBoundaryPaths();
        System.out.println(obj.findPaths(2,2,2,0,0));
    }
}