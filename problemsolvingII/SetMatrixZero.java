public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] mat = {{1 ,- 1, 1},{-1, 0, 1},{1, -1, 1}};
        int n=mat.length;
        int m=mat[0].length;
        setMatrixZeroes(mat);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static  void setMatrixZeroes(int[][] mat) {
        // code here
        int n = mat.length;
        int m=mat[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i]) {
                    mat[i][j] = 0;
                }
                if (col[j]) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
