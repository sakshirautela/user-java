import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix2(int[][] matrix) {
        int rowLast = matrix.length - 1;
        int colLast = matrix[0].length - 1;

        int[] row = matrix[0];
        int[] prevRow;
        if (row[0] == 1)
            row[0] = rowLast + colLast + 2;
        for (int c = 1; c <= colLast; c++)
            if (row[c] == 1)
                row[c] = row[c - 1] + 1;
        for (int r = 1; r <= rowLast; r++) {
            prevRow = row;
            row = matrix[r];
            if (row[0] == 1)
                row[0] = prevRow[0] + 1;
            for (int c = 1; c <= colLast; c++)
                if (row[c] == 1)
                    row[c] = Math.min(row[c - 1], prevRow[c]) + 1;
        }
        row = matrix[rowLast];
        for (int c = colLast - 1; c >= 0; c--)
            if (row[c] > 1)
                row[c] = Math.min(row[c], row[c + 1] + 1);
        for (int r = rowLast - 1; r >= 0; r--) {
            prevRow = row;
            row = matrix[r];
            if (row[colLast] > 1)
                row[colLast] = Math.min(row[colLast], prevRow[colLast] + 1);
            for (int c = colLast - 1; c >= 0; c--)
                if (row[c] > 1)
                    row[c] = Math.min(row[c], Math.min(row[c + 1], prevRow[c]) + 1);
        }
        return matrix;
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[] distx = { 1, -1, 0, 0 };
        int[] disty = { 0, 0, 1, -1 };

        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            for (int i = 0; i < 4; i++) {
                int newx = x + distx[i];
                int newy = y + disty[i];
                if (newx >= 0 && newy >= 0 && newx < m && newy < n && (ans[newx][newy] == -1)) {
                    ans[newx][newy] = ans[x][y] + 1;
                    queue.offer(new int[] { newx, newy });
                }
            }
        }

        return ans;
    }
}