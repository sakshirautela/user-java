
import java.util.Arrays;
public class Convert1DArrayTo2DArray {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            // If not, return an empty 2D array
            return new int[0][0];
        }

        // Initialize the result 2D array with m rows and n columns
        int[][] resultArray = new int[m][n];

        // Fill the 2D array with elements from the original array
        for (int i = 0; i < original.length; i++) {
            resultArray[i / n][i % n] = original[i];
        }

        return resultArray;
    }
    public int[][] construct2DArray2(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        int[][] arr = new int[m][];

        for(int i=0; i<m; i++){
           arr[i] = Arrays.copyOfRange(original, i*n, i*n+n);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] res=construct2DArray(new int[]{1,2,3,4},2, 2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    
    }
}
