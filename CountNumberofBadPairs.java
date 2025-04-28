package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofBadPairs {
    public static long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];
            int goodPairsCount = diffCount.getOrDefault(diff, 0);
            badPairs += pos - goodPairsCount;

            diffCount.put(diff, goodPairsCount + 1);
        }

        return badPairs;
    }

    public long countBadPairs2(int[] nums) {
        Map<Integer, Integer> bag = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += -1 + bag.merge(nums[i] - i, 1, Integer::sum);
        }
        int len = nums.length;
        return 1L * len * (len - 1) / 2 - count;
    }

    public static void main(String[] args) {
        System.err.println(countBadPairs(new int[] {}));
    }
}