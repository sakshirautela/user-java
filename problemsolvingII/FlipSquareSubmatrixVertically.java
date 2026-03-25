public class FlipSquareSubmatrixVertically {
    public static void main(String[] args) {
        int[][] a = reverseSubmatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 1, 0, 3);
        for (int j = 0; j < a.length; j++) {
            for (int k = 0; k < a[j].length; k++) {
                System.out.print(a[j][k] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] temp = new int[k][k];
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                temp[i - x][j - y] = grid[i][j];
            }
        }
        int idx=k-1;
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                grid[i][j]= temp[idx][j];
            }
            idx--;
        }
        return grid;
    }
}
