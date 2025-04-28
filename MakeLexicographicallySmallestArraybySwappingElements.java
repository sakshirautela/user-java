package com.learn.java.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MakeLexicographicallySmallestArraybySwappingElements {
    public static void main(String[] args) {
        int[] res = lexicographicallySmallestArray(new int[] {}, 6);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] lexicographicallySmallestArrayDemo(int[] nums, int limit) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j] && nums[i] - nums[j] <= limit) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);

        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(currGroup, new LinkedList<Integer>(Arrays.asList(numsSorted[0])));

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                currGroup++;
            }
            numToGroup.put(numsSorted[i], currGroup);
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }

        return nums;
    }

    public int[] lexicographicallySmallestArray2(int[] nums, int limit) {
        int n = nums.length;

        class Pair {
            int index, value;

            Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        Pair[] pairs = new Pair[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(pairs, (a, b) -> a.value - b.value);

        Pair[] ids = Arrays.copyOf(pairs, n);

        int i = 0;
        while (i < n) {
            int j = i;
            i++;

            while (i < n && pairs[i].value - pairs[i - 1].value <= limit) {
                i++;
            }

            Arrays.sort(ids, j, i, (a, b) -> a.index - b.index);

            for (int k = j; k < i; k++) {
                ans[ids[k].index] = pairs[k].value;
            }
        }

        return ans;
    }
}