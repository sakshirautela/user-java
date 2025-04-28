package com.learn.java.problemsolving;

public class ContiguousSubArrays {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[] {31,30,31,32}));
    }

    public static long continuousSubarrays(int[] nums) {
        int i = 0, j = 0;
        int min, max;
        long len = 0, res = 0;
        min = max = nums[i];
        for (i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (max - min > 2) {
                len = i - j;
                res += ((len * (len + 1)) / 2);
                j = i;
                min = max = nums[i];
                while (
                    j > 0 && Math.abs(nums[i] - nums[j - 1]) <= 2
                ) {
                    j--;
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                }
                if (j < i) {
                    len = i - j;
                    res -= ((len * (len + 1)) / 2);
                }
            }
        }

        len = i - j;
        res += ((len * (len + 1)) / 2);

        return res;
    }
}