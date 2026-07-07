package problemsolvingIII;

import java.util.*;

public class FindtheSafestPathinaGrid {
    static void main() {
        System.out.println(maximumSafenessFactor(new ArrayList<>()));
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = grid.get(i).get(j);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1)
                    q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] head = q.poll();
            int i = head[0];
            int j = head[1];
            int v = mat[i][j];

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && mat[x][y] == 0) {
                    mat[x][y] = v + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{mat[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] head = pq.poll();
            int sf = head[0];
            int i = head[1];
            int j = head[2];

            if (i == n - 1 && j == n - 1)
                return sf - 1;

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && mat[x][y] > 0) {
                    pq.add(new int[]{Math.min(sf, mat[x][y]), x, y});
                    mat[x][y] *= -1;
                }
            }
        }

        return mat[n - 1][n - 1] - 1;
    }
}
