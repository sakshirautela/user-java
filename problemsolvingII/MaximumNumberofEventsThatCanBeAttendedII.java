import java.util.Arrays;

public class MaximumNumberofEventsThatCanBeAttendedII {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[][] { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 10 } }, 2));
    }
    public int maxValueFast(int[][] events, int k) {
        if(k == 1) {
            int max = 0;
            for(int[] event : events) max = Math.max(max, event[2]);
            return max;
        }
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
         int nextIndex[] = new int[n];
        for (int i = 0; i < n; i++) {
            nextIndex[i] = binarysearch(events, i, n - 1, events[i][1]);

        }
        int[][] dp = new int[n + 1][k + 1];
        for(int i = 1; i <=n; i++) {
            int index = nextIndex[i];
            for(int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i -1][j], dp[index][j - 1] + events[i][2]);
            }
        }
        return dp[k][n];
    }
    public static int maxValue2(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int nextIndex[] = new int[n];
        for (int i = 0; i < n; i++) {
            nextIndex[i] = binarysearch(events, i, n - 1, events[i][1]);

        }
        print(dp);
        return maxValueUtilDFS2(events, n, 0, 0, k, -1, dp,nextIndex);
    }

    private static int maxValueUtilDFS2(int[][] events, int n, int count, int i, int k, int preEnd, int[][] dp, int[] nextIndex) {
        if (count == k || i == n) {
            return 0;
        }
        if (events[i][0] <= preEnd) {
            return maxValueUtilDFS2(events, n, count, i + 1, k, preEnd, dp,nextIndex);

        }
        if (dp[count][i] != -1) {
            return dp[count][i];
        }
        int result = Math.max(events[i][2] + maxValueUtilDFS2(events, n, count + 1, nextIndex[i], k, events[i][1], dp,nextIndex),
                maxValueUtilDFS2(events, n, count, i + 1, k, preEnd, dp,nextIndex));
        dp[count][i] = result;
        return dp[count][i];
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        print(dp);
        return maxValueUtilDFS(events, n, 0, 0, k, -1, dp);
    }

    private static int maxValueUtilDFS(int[][] events, int n, int count, int i, int k, int preEnd, int[][] dp) {
        if (count == k || i == n) {
            return 0;
        }
        if (events[i][0] <= preEnd) {
            return maxValueUtilDFS(events, n, count, i + 1, k, preEnd, dp);

        }
        if (dp[count][i] != -1) {
            return dp[count][i];
        }
        int nextIndex = binarysearch(events, i, n - 1, events[i][1]);
        int result = Math.max(events[i][2] + maxValueUtilDFS(events, n, count + 1, nextIndex, k, events[i][1], dp),
                maxValueUtilDFS(events, n, count, i + 1, k, preEnd, dp));
        dp[count][i] = result;
        return dp[count][i];
    }

    private static int binarysearch(int[][] events, int i, int j, int val) {
        while (i < j) {
            int mid = (i + j) / 2;
            if (events[mid][1] <= val) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    public static int maxValueTLE(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        print(dp);
        return maxValueUtil(events, n, 0, 0, k, -1, dp);
    }

    private static int maxValueUtil(int[][] events, int n, int count, int i, int k, int preEnd, int[][] dp) {
        if (count == k || i == n) {
            return 0;
        }
        if (events[i][0] <= preEnd) {
            return maxValueUtil(events, n, count, i + 1, k, preEnd, dp);

        }
        if (dp[count][i] != -1) {
            return dp[count][i];
        }

        int result = Math.max(events[i][2] + maxValueUtil(events, n, count + 1, i + 1, k, events[i][1], dp),
                maxValueUtil(events, n, count, i + 1, k, preEnd, dp));
        dp[count][i] = result;
        return dp[count][i];
    }

    private static void print(int[][] dp) {
        for (int i[] : dp) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}