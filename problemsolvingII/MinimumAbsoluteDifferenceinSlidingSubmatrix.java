import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceinSlidingSubmatrix {
    static void main() {
        int[][] matrix = minAbsDiff(new int[][]{{}}, 3);
    }

    public static int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n - k + 1][m - k + 1];
        for (int i = 0; i + k <= n; i++) {
            for (int j = 0; j + k <= m; j++) {
                List<Integer> li = new ArrayList<>();
                for (int e = i; e < i + k; e++) {
                    for (int p = j; p < j + k; p++) {
                        li.add(grid[e][p]);
                    }
                }
                Collections.sort(li);
                int r = Integer.MAX_VALUE;
                for (int e = 1; e < li.size(); e++) {
                    r = Math.min(r, Math.abs(li.get(e) - li.get(e - 1)));
                }
                if (r == Integer.MAX_VALUE) {
                    result[i][j] = 0;
                } else {

                    result[i][j] = r;
                }
            }
        }
        return result;
    }

    public int getmn(int[] arr) {
        Arrays.sort(arr);
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                mn = Math.min(mn, Math.abs(arr[i] - arr[i - 1]));
            }

        }
        return mn == Integer.MAX_VALUE ? 0 : mn;
    }

    public int[][] minAbsDiffFast(int[][] grid, int k) {
        // 1 1 1
        // 1 1 1
        // 1 1 1
        int m = grid.length, n = grid[0].length;
        int[][] answ = new int[m - k + 1][n - k + 1];
        for (int row = 0; row < m - k + 1; row++) {
            for (int col = 0; col < n - k + 1; col++) {
                int[] arr = new int[k * k];
                int idx = 0;
                for (int i = row; i < row + k; i++) {
                    for (int j = col; j < col + k; j++) {
                        arr[idx] = grid[i][j];
                        idx++;
                    }
                }
                answ[row][col] = getmn(arr);


            }
        }
        return answ;
    }
}