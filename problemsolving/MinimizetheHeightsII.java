
import java.util.*;

public class MinimizetheHeightsII {
    static int minimzeHeight(int n, int k, int[] arr) {
        Arrays.sort(arr);
        int min = arr[0], max = arr[n - 1];
        int res = max - min;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - k < 0) {
                continue;
            }
            min = Math.min(arr[i] - k, arr[0] + k);
            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(minimzeHeight(8, 7, new int[] { 1, 8, 10, 6, 4, 6, 9, 1 }));
    }
}
