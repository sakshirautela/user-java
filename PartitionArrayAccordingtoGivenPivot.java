package com.learn.java.problemsolving;

public class PartitionArrayAccordingtoGivenPivot {
    public static void main(String[] args) {
        System.out.println(pivotArray(new int[] {}, 10));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int idx = -1;
        int eq = 0;
        int[] res = new int[nums.length];
        for (int i : nums) {
            if (i < pivot) {
                idx++;
            }
            if (i == pivot) {
                eq++;
            }
        }
        int i = 0, j = idx + eq + 1, e = idx + 1;
        for (int num : nums) {
            if (num < pivot) {
                res[i] = num;
                i++;
            } else if (num > pivot) {
                res[j] = num;
                j++;
            } else {
                res[e] = num;
                e++;
            }

        }
        return res;
    }
}