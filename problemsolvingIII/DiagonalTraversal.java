package problemsolvingIII;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int[] res = findDiagonalOrder(new int[][]{{}});
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;

        for (int i = 0; i < m * n; i++) {
            res[i] = mat[r][c];

            if ((r + c) % 2 == 0) {
                if (c == n - 1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) c++;
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }

        return res;
    }
}