public class CountServersThatCommunicate {
    public static void main(String args[]) {
        System.out.println(countServers(new int[][] { {} }));
    }

    public static int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rowCount = new int[row];
        int[] colCount = new int[col];
        for (int i = 0; i < row; i++) {
            int r = 0;
            for (int j = 0; j < col; j++) {
                r += grid[i][j];
            }
            rowCount[i] = r;
        }
        for (int i = 0; i < col; i++) {
            int r = 0;
            for (int j = 0; j < row; j++) {
                r += grid[j][i];
            }
            colCount[i] = r;
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }

    public int countServers2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}