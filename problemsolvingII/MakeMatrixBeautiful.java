public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        System.out.println(balanceSums(new int[][]{{4, 1}, {4, 1}}));
    }

    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length;
        int maxsum = 0;
        for (int i = 0; i < n; i++) {
            int row=0;
            int col=0;
            for (int j = 0; j < n; j++) {
                row+=mat[i][j];
                col+=mat[j][i];
            }
            maxsum=Math.max(row,maxsum);
            maxsum=Math.max(col,maxsum);
        }
        int result=0;
        for (int i = 0; i < n; i++) {
            int row=0;
            for (int j = 0; j < n; j++) {
                row+=mat[i][j];
            }
            result+=maxsum-row;
        }
        return result;
    }
}
