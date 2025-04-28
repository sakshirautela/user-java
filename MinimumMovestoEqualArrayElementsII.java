package com.learn.java.problemsolving;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[] {}));
    }

    public static int minMoves2(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            result += Math.abs(nums[i] - nums[j]);
            j--;
            i++;
        }
        return result;
    }

    public int minMoves222(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int med = quickSelect(nums, nums.length / 2 + 1, 0, nums.length - 1);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - med);
        }
        return res;
    }

    private int quickSelect(int[] nums, int k, int l, int r) {
        if (l >= r)
            return nums[r];
        int pivot = nums[l + (r - l) / 2], i = l - 1, j = r + 1;
        while (i < j) {
            while (nums[++i] < pivot)
                ;
            while (nums[--j] > pivot)
                ;
            if (i < j)
                swap(nums, i, j);
        }
        int sl = j - l + 1;
        if (k <= sl)
            return quickSelect(nums, k, l, j);
        return quickSelect(nums, k - sl, j + 1, r);
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}