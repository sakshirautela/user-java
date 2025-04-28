package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysbySummingValues {
    public static void main(String[] args) {
        int[][] res = mergeArrays(new int[][] { {} }, new int[][] { {} });
        for (int[] i : res) {
            for (int a : i) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> keyToSum = new TreeMap<>();
        for (int[] nums : nums1) {
            keyToSum.put(nums[0], nums[1]);
        }
        for (int[] nums : nums2) {
            keyToSum.put(nums[0], keyToSum.getOrDefault(nums[0], 0) + nums[1]);
        }

        List<int[]> mergedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : keyToSum.entrySet()) {
            mergedList.add(new int[] { entry.getKey(), entry.getValue() });
        }

        int[][] mergedArray = new int[mergedList.size()][2];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }

        return mergedArray;
    }
}