import java.util.Arrays;
import java.util.Comparator;

public class MaximumWallsDestroyedbyRobots {
    static void main() {
        //System.out.println(maxWalls(new int[]{1,2},new int[]{100,1},new int[]{10}));
        System.out.println(maxWallsRecusrion(new int[]{17, 59, 32, 11, 72, 18}, new int[]{5, 7, 6, 5, 2, 10}, new int[]{17, 25, 33, 29, 54, 53, 18, 35, 39, 37, 20, 14, 34, 13, 16, 58, 22, 51, 56, 27, 10, 15, 12, 23, 45, 43, 21, 2, 42, 7, 32, 40, 8, 9, 1, 5, 55, 30, 38, 4, 3, 31, 36, 41, 57, 28, 11, 49, 26, 19, 50, 52, 6, 47, 46, 44, 24, 48}));
    }

    public static int maxWallsRecusrion(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        if (n == 0) return 0;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        int[] numBetween = new int[n];
        int[] right = new int[n];
        int[] left = new int[n];
        Arrays.sort(idx, Comparator.comparingInt(a -> robots[a]));
        Arrays.sort(walls);
        for (int k = 0; k < n; k++) {
            int i = robots[idx[k]] - distance[idx[k]];
            if (k > 0) {

                i = Math.max(i, robots[idx[k - 1]] + 1);
            }
            int j = robots[idx[k]] + distance[idx[k]];
            if (k + 1 < n) {
                j = Math.min(j, robots[idx[k + 1]] - 1);
            }
            int ull = upperBound(walls, robots[idx[k]]);
            int llr = lowerBound(walls, robots[idx[k]]);
            int ulr = upperBound(walls, j);
            int lll = lowerBound(walls, i);
            right[k] = ulr - llr;
            left[k] = ull - lll;
            if (k == 0) {
                continue;
            }
            int lWall = lowerBound(walls, robots[idx[k - 1]]);
            numBetween[k] = ull - lWall;

        }
        int l = left[0];
        int r = right[0];
        for (int i = 1; i < n; i++) {
            int newL = Math.max(l + left[i], r - right[i - 1] + Math.min(left[i] + right[i - 1], numBetween[i]));
            int newR = Math.max(r + right[i], l + right[i]);
            l = newL;
            r = newR;
        }
        return Math.max(l, r);
    }

    public static int lowerBound(int[] walls, int num) {
        int i = 0;
        int j = walls.length;
        while (i < j) {
            int mid = (i + j) / 2;
            if (walls[mid] < num) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static int upperBound(int[] walls, int num) {
        int i = 0;
        int j = walls.length;
        while (i < j) {
            int mid = (i + j) / 2;
            if (walls[mid] <= num) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}