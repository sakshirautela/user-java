import java.text.Collator;
import java.util.ArrayList;

public class SpiralMat2 {
    static int[][] spiralMatrix(int[][] matrix){
        int[][] ans=new int[matrix.length][matrix.length];
        int[] list=new int[matrix.length];
        int startCol=0;
        while(startCol<matrix[0].length){
            for (int i = 0; i < matrix.length; i++) {
                list[i]=(matrix[startCol][i]);
            }
            ans[startCol]=list;
            startCol++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 8,9,4 }, { 7,6,5 } };
        System.out.println(spiralMatrix(matrix));
    }
}
