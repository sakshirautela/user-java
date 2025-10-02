import java.util.Arrays;

public class c4 {
    public static void main(String[] args) {
        System.out.println(maxWalls(new int[]{10, 2}, new int[]{5, 1}, new int[]{5, 2, 7}));
    }

    public static int maxWalls(int[] robots, int[] distance, int[] walls) {
        Arrays.sort(walls);
        int n = robots.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int robot = robots[i];
            int d = distance[i];

            int leftCount = countInRange(walls, robot - d, robot);

            int rightCount = countInRange(walls, robot, robot + d);

            res += Math.max(leftCount, rightCount);
        }
        return res;
    }

    private static int countInRange(int[] arr, int low, int high) {
        int leftIndex = lowerBound(arr, low);
        int rightIndex = upperBound(arr, high);
        return rightIndex - leftIndex;
    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
