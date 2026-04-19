package problemsolvingIII;

public class ToeplitzMatrix {
    static void main() {
        System.out.println(isToeplitz(new int[][]{{6, 7, 8}, {4, 6, 7}, {1, 4, 6}}));
    }

    public static boolean isToeplitz(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        for (int k = 0; k < m; k++) {
            int i = 0;
            int j = k;
            int el = mat[i][j];
            while (i < n && j < m) {
                if (mat[i][j] != el) {
                    return false;
                }
                i++;
                j++;
            }
        }
        for (int k = 1; k < n; k++) {
            int i = k;
            int j = 0;
            int el = mat[i][j];
            while (i < n && j < m) {
                if (mat[i][j] != el) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}