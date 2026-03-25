import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MinimumSwapstoArrangeaBinaryGrid {
    static void main() {
        System.out.println(minSwaps(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 0}}));
    }

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == 0) count++;
                else break;
            }
            list.add(count);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {

            int required = n - 1 - i;
            int j = i;
            while (j < n && list.get(j) < required) {
                j++;
            }

            if (j == n) return -1;
            while (j > i) {
                int temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                res++;
                j--;
            }
        }

        return res;
    }
}