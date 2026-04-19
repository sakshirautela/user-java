package problemsolvingIII;

import java.util.*;

public class MinimumTotalDistanceTraveled {
    static void main() {
        System.out.println(
                minimumTotalDistanceRecursion(
                        new ArrayList<>(List.of(0, 4, 6)),
                        new int[][]{{2, 2}, {6, 2}}
                )
        );
    }

    public static long minimumTotalDistanceDP(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        Collections.sort(robot);
        ArrayList<Integer> factories = new ArrayList<>();
        for (int[] row : factory) {
            for (int i = 0; i < row[1]; i++) {
                factories.add(row[0]);
            }
        }
        int m = factories.size();
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 1;
        return dp[n][m];
    }
        public static long minimumTotalDistanceRecursion(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        Collections.sort(robot);
        ArrayList<Integer> factories = new ArrayList<>();
        for (int[] row : factory) {
            for (int i = 0; i < row[1]; i++) {
                factories.add(row[0]);
            }
        }
        int m = factories.size();
        long[][] dp = new long[n + 1][m + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumTotalDistanceUtil(0, n, 0, m, factories, robot, dp);

    }

    private static long minimumTotalDistanceUtil(int i, int n, int j, int m, ArrayList<Integer> factory, List<Integer> robot, long[][] dp) {
        if (i == n) return 0;

        if (j >= m) return Long.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        long skip = minimumTotalDistanceUtil(i, n, j + 1, m, factory, robot, dp);
        int d = Math.abs(robot.get(i)- factory.get(j));
        long next = minimumTotalDistanceUtil(i + 1, n, j + 1, m, factory, robot, dp);

        long notSkip = Long.MAX_VALUE;
        if (next != Long.MAX_VALUE) {
            notSkip = d + next;
        }
        return dp[i][j] = Math.min(skip, notSkip);
    }

    /*
    java.lang.RuntimeException: Error when serializing long: 9223372036854775807 out of range [-(2^53-1), 2^53-1]
        at __Serializer__.serialize(Unknown Source)
      at line 94, __Driver__.main
     */
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        int m = factory.length;
        Collections.sort(robot);
        int distace = 0;
        for (int i = 0; i < n; i++) {
            int d = -1;
            int d2 = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (d == -1 && factory[j][1] >= 1) {
                    d = j;
                    d2 = Math.abs(factory[j][0] - robot.get(i));
                } else {
                    int dist = Math.abs(factory[j][0] - robot.get(i));
                    if (dist < d2 && factory[j][1] >= 1) {
                        d2 = dist;
                        d = j;
                    }
                }
            }
            factory[d][1]--;
            distace += d2;
        }
        return distace;
    }
}
