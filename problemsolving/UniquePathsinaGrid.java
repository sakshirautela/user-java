import java.util.Arrays;

public class UniquePathsinaGrid {
    public static void main(String[] args) {
        System.out.println(uniquePaths(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
    }

    private static int uniquePaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        // If starting or ending cell is an obstacle, return 0
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return 0;
        }
        
        // Initialize dp array with 0
        int[] dp = new int[m];
        
        // Set the value for the bottom-right cell
        dp[m-1] = 1;
        
        // Fill the bottom row first
        for(int j = m-2; j >= 0; j--) {
            
            // As this is an obstacle, no paths will 
            // exist from this cell.
            if(grid[n-1][j] == 1) {
                dp[j] = 0;
            }
            
            // Otherwise, a straight path to 
            // n-1, m-1 exists 
            else {
                dp[j] = dp[j+1];
            }
        }
        
        // Process each row from bottom to top
        for(int i = n-2; i >= 0; i--) {
            
            // Process the rightmost column of the current row
            if(grid[i][m-1] == 1) {
                dp[m-1] = 0;
            }
            
            // Process each cell from right to left
            for(int j = m-2; j >= 0; j--) {
                
                // If current cell is an obstacle, paths = 0
                if(grid[i][j] == 1) {
                    dp[j] = 0;
                }
                
                // Otherwise, paths = sum of right and down paths
                else {
                    dp[j] = dp[j] + dp[j+1];
                }
            }
        }
        
        return dp[0];
    }
}
