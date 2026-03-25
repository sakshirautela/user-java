void main() {
    int[][] matrix = constructProductMatrix(new int[][]{{1, 2}, {3, 4}});
    for (int[] matrixRow : matrix) {
        for (int row : matrixRow) {
            System.out.print(row + " ");
        }
        System.out.println();
    }
}

public static int[][] constructProductMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    long suffix = 1;
    int[][] res = new int[n][m];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            res[i][j] = Math.toIntExact(suffix);
            suffix = (suffix * grid[i][j]) % 12345;
        }
    }
    long prefix = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            res[i][j] = Math.toIntExact((long) (res[i][j] * prefix)) % 12345;
            prefix = (prefix * grid[i][j]) % 12345;
        }
    }
    return res;
}