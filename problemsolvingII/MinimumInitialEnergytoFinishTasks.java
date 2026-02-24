import java.util.Arrays;

public class MinimumInitialEnergytoFinishTasks {
    static void main() {
        System.out.println(minimumEffortBS(new int[][]{
                {1, 3},
                {2, 4},
                {10, 11},
                {10, 12},
                {8, 9}
        }));
    }

    public static int minimumEffortBS(int[][] tasks) {
        int left = tasks[0][0];
        int right = (int) 1e9;
        int ans = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int diff = mid;
            boolean valiid = true;
            for (int[] task : tasks) {
                if (diff > task[1]) {
                    valiid = false;
                }
                diff -= task[0];
            }
            if (valiid) {
                ans = mid;
                left = mid - 1;
            } else {
                right = mid + 1;
            }
        }
        return ans;
    }

    public static int minimumEffort(int[][] arr) {
        int res = 0;
        Arrays.sort(arr, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        for (int[] a : arr) {
            res = Math.max(res + a[0], a[1]);
        }
        return res;
    }
}