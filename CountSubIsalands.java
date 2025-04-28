package com.learn.java.problemsolving;

public class CountSubIsalands {
        int n, m;
        int[][] isValid;
        int[] dx = new int[] {-1, 0 , 0 ,1};
        int[] dy = new int[] {0, -1, 1, 0};
        public int countSubIslands2(int[][] grid1, int[][] grid2) {
            n = grid1.length;
            m = grid1[0].length;
            isValid = new int[n][m];
            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0 ; j < m ; j++) {
                    if (isValid[i][j] == 0 && grid2[i][j] == 1) {
                        if (isSubIslands2(i, j, grid1, grid2)) {
                            num++;
                        }
                    }
                }
            }
            return num;
        }
    
        private boolean isSubIslands2(int r, int c, int[][] grid1, int[][] grid2) {
            if (grid1[r][c] != 1) {
                isValid[r][c] = -1;
                return false;
            }
            isValid[r][c] = 1;
            for (int k = 0 ; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (nr <  0 || nr >= n || nc < 0 || nc >= m) continue;
                if (isValid[nr][nc] == -1) {
                    isValid[r][c] = -1;
                    return false;
                }
                if (isValid[nr][nc] == 1) continue;
                if (grid2[nr][nc] == 1 && !isSubIslands2(nr, nc, grid1, grid2)) {
                    isValid[r][c] = -1;
                    return false;
                }
            }
            return true;
        }
    static boolean isIsland;

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid2[i][j]==1 && grid1[i][j]==1){
                    isIsland=true;     
                    dfs(grid1, grid2, visited, i, j, m, n);
                    if(isIsland){
                         res++;
                    }
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid2[i][j] == 0) {// || grid1[i][j]==0){
            return;
        }
        visited[i][j] = true;
        if (grid1[i][j] != grid2[i][j]) {
            isIsland = false;
        }
        dfs(grid1, grid2, visited, i - 1, j, m, n);
        dfs(grid1, grid2, visited, i, j - 1, m, n);
        dfs(grid1, grid2, visited, i, j + 1, m, n);
        dfs(grid1, grid2, visited, i + 1, j, m, n);

    }

    public static void main(String args[]) {
        System.out.println(countSubIslands(
                new int[][] { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
                        { 1, 0, 1, 0, 1 } },
                new int[][] { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
                        { 1, 0, 0, 0, 1 } }));
    }
}