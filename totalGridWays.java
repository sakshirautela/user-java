public class totalGridWays {
    public static void main(String[] args) {
        //System.out.println(gridWays(0, 0, 3, 2));
        //System.out.println(byFormula(10, 10));
        System.out.println(uniquePaths(3, 3));
    }
    public static int gridWays(int x,int y,int m,int n){
        if(x==m-1 && y==n-1){
            return 1;
        }
        else if(x==m || y==n){
            return 0;
        }
        int ways1 = gridWays(x+1, y, m, n);
        int ways2 = gridWays(x, y+1, m, n);
        return ways1+ways2;
    }
    public static long  byFormula(long b,long a){
        long total=fact(a-1+b-1)/(fact(a-1)*fact(b-1));
        return total;
    }
    public static long fact(long n){
        long factorial;

        if(n==0 || n==1){
            return 1;
        }
        else{
             factorial = (n)*fact(n-1);
        }
        return factorial;
    }
    
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base case
        dp[0][0] = 1;

        // Fill the first row and first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the result
        return dp[m - 1][n - 1];
    }
}
