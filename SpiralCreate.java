public class SpiralCreate {
    static int[][] createMatrix(int n){
        int[][] matrix = new int[n][n];
        int startCol=0;
        int startRow=0;
        int endCol=n-1;
        int endRow = n-1;
        int j=1;
        while(startCol<=endCol && startRow<=endRow){
            for (int i =startCol;i<=endCol; i++) {
                (matrix[startRow][i])=j;
                j++;
            }
            for (int i = startRow+1; i <= endRow; i++) {
                (matrix[i][endCol])=j;
                j++;
            }
            for (int i =endCol-1;i>=startCol;i-- ) {
                if(startRow==endRow){
                    break;
                }
                (matrix[endRow][i])=j;
                j++;
                
            }
            for (int i = endRow - 1; i > startCol; i--) {
                if (startCol == endCol) {
                    break;
                }
                (matrix[i][startCol])=j;
                j++;

            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return matrix;

    }
    static int[][] spiralMatrix(int n) {
        int[][] matrix =createMatrix(n);

        int[][] ans = new int[n][n];
        int startCol = 0;
        while (startCol < n) {
            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = (matrix[startCol][i]);
            }
            ans[startCol] = list;
            startCol++;
        }
        return ans;
    }

    public static void main(String[] args) {
        spiralMatrix(3);
    }
}
