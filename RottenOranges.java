import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] { {} }));
    }

    static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };;

    private static boolean isSafe(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    public static int orangesRotting(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean changed;

        int rotten = 0;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (true) {
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == rotten + 2) {
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (isSafe(x, y, n, m) && mat[x][y] == 1) {
                                mat[x][y] = mat[i][j] + 1;
                                changed = true;
                            }
                        }
                    }
                }
            }
            if (!changed) {
                break;
            }
            rotten++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    return -1;
                }
            }
        }

        return rotten;
    }


    static class Pair {
        int row;
        int col;
        int time;
        Pair (int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting2(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.offer (new Pair (i, j, 0));
                    vis[i][j] = true;
                }
                if (mat[i][j] == 1)
                    cnt++;
            }
        }
        
        int time = 0, cf = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            time = Math.max(time, t);
            
            for (int i = 0; i < dirs.length; ++i){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && mat[nr][nc] == 1) {
                    q.offer (new Pair (nr, nc, t + 1));
                    vis[nr][nc] = true;
                    cf++;
                }
            }
        }
        return (cf != cnt) ? - 1 : time;
    }
}