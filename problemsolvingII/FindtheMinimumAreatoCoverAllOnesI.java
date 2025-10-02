public class FindtheMinimumAreatoCoverAllOnesI {
    public static void main(String[] args) {
        System.out.println(minimumArea(new int[][]{{0, 1, 0},
                {1, 0, 1}}));
    }

    public static int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxb = -1;
        int minb = n;
        int maxl = -1;
        int minl = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxl = Math.max(j, maxl);
                    minl = Math.min(j, minl);
                    maxb = Math.max(maxb, i);
                    minb = Math.min(minb, i);
                }

            }
        }
        return ((maxb - minb + 1) * (maxl - minl + 1));
    }
}
