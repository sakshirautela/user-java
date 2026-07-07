package problemsolvingIII;

import java.util.Scanner;

public class CyclicallyRotatingaGrid {
    public static void main(String[] args) {
        int[][] grid=rotateGrid(new int[][]{{}},9);
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                System.out.print(grid[row][col]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] rotateGrid(int[][] grid, int k) {
int n=grid.length;
int m=grid[0].length;
k=k%((n*2)+(m-2)*2);
for(int r=0;r<k;r++){
    rotate(grid);
}
return grid;
    }

    private static void rotate(int[][] grid) {
        
    }
}
