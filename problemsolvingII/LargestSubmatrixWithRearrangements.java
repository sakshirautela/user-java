import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    static void main() {
        System.out.println(largestSubmatrix(new int[][]{{1, 1, 0}, {1, 0, 1}}));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (matrix[i][j] == 1) {

                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = matrix[i][j];
                int l = m - j;
                res = Math.max(res, h * l);
                //System.out.print(matrix[i][j] + " ");
            }
        }
        return res;
    }
}