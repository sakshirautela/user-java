import java.util.*;

public class SortMatrixbyDiagonals {
    public static void main(String[] args) {
        int[][] arr = { {} };
        arr = sortMatrix(arr);
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sortMatrix(int[][] grid) {
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<Integer, PriorityQueue<Integer>>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hm.containsKey(i - j)) {
                    hm.get(i - j).add(grid[i][j]);
                } else {
                    if (i - j >= 0) {
                        hm.put(i - j, new PriorityQueue<Integer>(Collections.reverseOrder()));
                    } else {
                        hm.put(i - j, new PriorityQueue<Integer>());
                    }
                    hm.get(i - j).add(grid[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = hm.get(i - j).remove();
            }
        }
        return grid;
    }

    public int[][] sortMatrix2(int[][] grid) {
        int len = grid.length;

        // sorting the lower left
        for (int a = 0; a < len; a++) {
            for (int i = a, j = 0; i < len; i++, j++) {
                for (int n = i + 1, m = j + 1; n < len; n++, m++) {
                    if (grid[i][j] < grid[n][m]) {
                        int temp = grid[i][j];
                        grid[i][j] = grid[n][m];
                        grid[n][m] = temp;
                    }

                }

            }
        }

        // sorting the upper right
        for (int a = 1; a < len; a++) {
            for (int i = 0, j = a; j < len; i++, j++) {
                for (int n = i + 1, m = j + 1; m < len; n++, m++) {
                    if (grid[i][j] > grid[n][m]) {
                        int temp = grid[i][j];
                        grid[i][j] = grid[n][m];
                        grid[n][m] = temp;
                    }
                }
            }
        }

        return grid;
    }
}