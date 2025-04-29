
import java.util.*;

public class SortMatrixbyDiagonalsII {
    public int[][] diagonalSort(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            sortDiagonal(mat, row, 0);
        }

        for (int col = 1; col < mat[0].length; col++) {
            sortDiagonal(mat, 0, col);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        int diagonalSize = Math.min(mat.length - row, mat[0].length - col);
        int[] count = new int[101];
        for (int i = 0; i < diagonalSize; i++) {
            count[mat[row + i][col + i]]++;
        }

        int countP = 1;
        for (int i = 0; i < diagonalSize; i++) {
            while (count[countP] == 0) countP++;
            mat[row + i][col + i] = countP;
            count[countP]--;
        }
    }
    public int[][] diagonalSort2(int[][] grid) {
        HashMap<Integer,PriorityQueue<Integer>> hm=new HashMap<Integer,PriorityQueue<Integer>>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(hm.containsKey(i-j)){
                    hm.get(i-j).add(grid[i][j]);
                }else{
                    hm.put(i-j,new PriorityQueue<Integer>());
                    hm.get(i-j).add(grid[i][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                grid[i][j]=hm.get(i-j).remove();
            }
        }
        return grid;
    }
}
