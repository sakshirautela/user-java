public class SpecialPositionsinaBinaryMatrix {
    static void main() {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    public static int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowCount[i]++;
                colCount[j]++;

            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowCount[i] + colCount[j] == 2 && mat[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}