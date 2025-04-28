package com.learn.java.problemsolving;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[] {}));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if 2 * num or num / 2 exists in the set
            if (
                seen.contains(2 * num) ||
                (num % 2 == 0 && seen.contains(num / 2))
            ) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }
        // No valid pair found
        return false;
    }
    public boolean checkIfExist2(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Fixed initialization and condition for outer loop
            float t = (float) arr[i] / 2;
            int x = Search(arr, t);
            if (x != i && x != -1) {
                return true;
            }
        }
        return false;
    }

    static int Search(int[] arr, float target) {
        for (int i = 0; i < arr.length; i++) { // Fixed initialization and condition for inner loop
            if ((float) arr[i] == target) { // Fixed comparison with float target
                return i;
            }
        }
        return -1;
    }
}
