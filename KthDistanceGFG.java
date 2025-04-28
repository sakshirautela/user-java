package com.learn.java.problemsolving;

import java.util.HashSet;

public class KthDistanceGFG {
    public static boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                return true;
            set.add(arr[i]);
            if (i >= k)
                set.remove(arr[i - k]);
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(checkDuplicatesWithinK(new int[] {}, 4));
    }
}