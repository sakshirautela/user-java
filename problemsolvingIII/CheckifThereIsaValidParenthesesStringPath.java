package problemsolvingIII;

public class CheckifThereIsaValidParenthesesStringPath {
    static void main() {
        System.out.println(hasValidPath(new char[][]{}));
    }
    public static boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if ((n + m - 1) % 2 != 0 || grid[0][0] == ')'
                || grid[n - 1][m - 1] == '(') {
            return false;
        }

        Boolean[][][]dp = new Boolean[n][m][n+m]; //3d becuase of the open number total length of string will be n+m-1;
        return hasValidPathUtil(grid,n,m,0,0,0,dp);
    }

    private static boolean hasValidPathUtil(char[][] grid, int n, int m, int i, int j, int open, Boolean[][][] dp) {
        int newOpen = open + (grid[i][j] == '(' ? 1 : -1);
        if(newOpen<0){
            return false;
        }
            if (i == n - 1 && j == m - 1) {
                return newOpen == 0;
            }

            if (dp[i][j][newOpen]!=null ) {
                return dp[i][j][newOpen];
            }
            boolean result=false;
        if(i+1<n) {
            result = hasValidPathUtil(grid, n, m, i + 1, j, newOpen, dp);
        }
    if(!result && j+1<m){
        result=hasValidPathUtil(grid, n, m, i, j + 1, newOpen, dp);
    }

            return dp[i][j][newOpen]=result;
        }
}
