public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public static void main(String[] args) {
        System.out.println(findRotation(
                new int[][] {
                        {1, 0, 0},
                        {1, 0, 1},
                        {0, 0, 1}
                },
                new int[][] {
                        {0, 1, 1},
                        {0, 0, 0},
                        {1, 1, 0}
                }
        ));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        for (int k = 0; k < 4; k++) {
            if (areEqual(mat, target)) return true;
            rotate(mat);
        }
        return false;
    }

    static void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }

    static boolean areEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}