import java.util.*;
public class LargestMatrixRearrangements {
    public static void largestSubmatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            Arrays.sort(matrix[i]);
            reverse(matrix[i]);
        }
        
    }
    private static void reverse(int[] a) {
        int e=a.length-1;
        int s=0;
        while(s<e){
            int temp=a[s];
            a[s]=a[e]; 
            a[e]=temp;
            s++;e--;
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};
        largestSubmatrix(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}