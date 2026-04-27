package problemsolvingIII;

public class CheckifThereisaValidPathinaGrid {
    static void main() {
        System.out.println(hasValidPath(new int[][]{{1,1,2}}));
    }

    public static boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return hasValidPathUtil(grid, 0, 0, n, m, visited);
    }
    static int[][][] dirs = {
            {},
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
    };    private static boolean hasValidPathUtil(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        if(i==n-1 && j==m-1) {
            return true;
        }
        visited[i][j] = true;
        for(int[] d:dirs[grid[i][j]]){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m || visited[ni][nj]) {
                continue;
            }
            for(int[] d2:dirs[grid[ni][nj]]) {
                if(ni+d2[0]==i && nj+d2[1]==j) {

                if (hasValidPathUtil(grid, ni, nj, n, m, visited)){
                    return true;
                }
                }
            }
        }
        return false;
    }
}