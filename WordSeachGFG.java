public class WordSeachGFG{
    static public boolean isWordExist(char[][] grid, String word) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search2D(grid, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean search2D(char[][] grid, int row, int col,String word) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
        for (int dir = 0; dir < 8; dir++) {
            int k, currX = row + x[dir],
                   currY = col + y[dir];
            for (k = 1; k < len; k++) {
                if (currX >= m || currX < 0 || currY >= n
                    || currY < 0)
                    break;

                if (grid[currX][currY] != word.charAt(k))
                    break;

                currX += x[dir];
                currY += y[dir];
            }

            if (k == len)
                return true;
        }

        return false;
    }
    
}
/*import java.util.*;

class GfG {

    // This function searches for the given word
    // in all 8 directions from the coordinate.
    static boolean search2D(char[][] grid, int row, int col,String word) {
        int m = grid.length;
        int n = grid[0].length;

        // return false if the given coordinate
        // does not match with first index char.
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // x and y are used to set the direction in which
        // word needs to be searched.
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // This loop will search in all the 8 directions
        for (int dir = 0; dir < 8; dir++) {
            int k, currX = row + x[dir],
                   currY = col + y[dir];

            // First character is already checked, match
            // remaining
            for (k = 1; k < len; k++) {
                if (currX >= m || currX < 0 || currY >= n
                    || currY < 0)
                    break;

                if (grid[currX][currY] != word.charAt(k))
                    break;

                currX += x[dir];
                currY += y[dir];
            }

            if (k == len)
                return true;
        }

        return false;
    }

    // This function calls search2D for each coordinate
    static int[][] searchWord(char[][] grid, String word) {
        int m = grid.length;
        int n = grid[0].length;

        // Max possible occurrences
        int[][] ans = new int[m * n][2];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search2D(grid, i, j, word)) {
                    ans[count][0] = i;
                    ans[count][1] = j;
                    count++;
                }
            }
        }

        // Resize the array to fit the actual number of
        // found coordinates
        int[][] result = new int[count][2];
        for (int i = 0; i < count; i++) {
            result[i] = ans[i];
        }

        return result;
    }

    static void printResult(int[][] ans) {
        for (int[] coords : ans) {
            System.out.print( "{" + coords[0] + "," + coords[1] + "}" + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        char[][] grid = { { 'a', 'b', 'a', 'b' },
                          { 'a', 'b', 'e', 'b' },
                          { 'e', 'b', 'e', 'b' } };
        String word = "abe";

        int[][] ans = searchWord(grid, word);

        printResult(ans);
    }
} 
public class WordSearch {
    
    // Directions: up, down, left, right
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    
    public static boolean exist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0) && dfs(mat, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean dfs(char[][] mat, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || visited[x][y] || mat[x][y] != word.charAt(index)) {
            return false;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            
            if (dfs(mat, word, index + 1, newX, newY, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
    
    public static void main(String[] args) {
        char[][] mat1 = {
            {'T', 'E', 'E'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word1 = "GEEK";
        
        System.out.println(exist(mat1, word1)); // Output: true
        
        char[][] mat2 = {
            {'T', 'E', 'U'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word2 = "GEEK";
        
        System.ou
*/