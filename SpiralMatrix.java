public class SpiralMatrix{
    void spiralMatrix(int[][] matrix){
        int startCol=0;
        int startRow=0;
        int endCol=matrix[0].length-1;
        int endRow = matrix.length-1;
        while(startCol<=endCol && startRow<=endRow){
            for (int i =startCol;i<=endCol; i++) {
                System.out.print(matrix[startRow][i]+" ");
            }
            for (int i = startRow+1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol]+" ");
            }
            for (int i =endCol-1;i>=startCol;i-- ) {
                if(startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][i]+" ");
                
            }
            for (int i = endRow - 1; i > startCol; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");

            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }
    public static void main(String[] args) {
        SpiralMatrix m=new SpiralMatrix();
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        m.spiralMatrix(matrix);
    }
}