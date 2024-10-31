import java.util.*;
public class SpiralMatrixIV {
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix=new int[m][n];
        int startCol=0;
        int startRow=0;
        int endCol=n-1;
        int endRow = m-1;
        Arrays.fill(matrix,-1);
        while(startCol<=endCol && startRow<=endRow){
            for (int i =startCol;i<=endCol && head!=null; i++) {
                matrix[startRow][i]=head.val;
                head=head.next;
            }
            for (int i = startRow+1; i <= endRow  && head!=null; i++) {
                matrix[i][endCol]=head.val;
                head=head.next;
            }
            for (int i =endCol-1;i>=startCol && head!=null;i-- ) {
                if(startRow==endRow){
                    break;
                }
               matrix[endRow][i]=head.val;
                head=head.next;
            }
            for (int i = endRow - 1; i > startCol && head!=null; i--) {
                if (startCol == endCol) {
                    break;
                }
                matrix[i][startCol]=head.val;
                head=head.next;
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return matrix;
    }
    public static void main(String[] args){
        System.out.println(spiralMatrix(3,5,new ListNode(0)));
    }
}