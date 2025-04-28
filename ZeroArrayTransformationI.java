package com.learn.java.problemsolving;

public class ZeroArrayTransformationI {
    public static void main(String[] args) {
        System.out.println(isZeroArray(new int[] { 2 }, new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 } }));
    }

    public static boolean isZeroArrayTLE(int[] nums, int[][] queries) {
        int n = queries.length;
        int zero = 0;
        for (int i : nums) {
            zero += i == 0 ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            zero += isQueries(queries[i][0], queries[i][1], nums);
        }
        return zero == nums.length;
    }

    private static int isQueries(int s, int e, int[] nums) {
        int a = 0;
        for (int i = s; i <= e; i++) {
            if (nums[i] == 1) {
                a++;
            }
            nums[i]--;
        }
        return a;
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int sum = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < queries.length; i++) {
            preSum[queries[i][0]]--;
            preSum[queries[i][1] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            sum += preSum[i];
            if (sum + nums[i] > 0) {
                return false;
            }
        }
        return true;
    }
}