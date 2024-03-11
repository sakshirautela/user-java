import java.util.*;

class MatrixSum {
    public static void helperRemove(int[] arr, int k) {
        for (int i = k; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int helper(int[] num) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int index = 0; index < num.length; index++) {
            if (num[index] > max) {
                max = num[index];
                maxIndex = index;
            }
        }
        helperRemove(num, maxIndex);
        return max;
    }

    public static int matrixSum(int[][] nums) {
        int sum = 0;
        int numRows = nums.length;
        int numCols = nums[0].length;

        while (numRows > 0 && numCols > 0) {
            int max = helper(nums[0]);
            for (int i = 1; i < numRows; i++) {
                max = Math.max(max, helper(nums[i]));
            }
            sum += max;
            numRows--;
        }

        return sum;
    }

    public static void main(String[] args) {
        int nums[][] = { { 7, 2, 1 }, { 6, 4, 2 }, { 6, 5, 3 }, { 3, 2, 1 } };
        System.out.println(matrixSum(nums));
    }
}
