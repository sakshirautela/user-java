package com.learn.java.problemsolving;

import java.util.HashMap;

public class SubarrayRangewithgivenSum {
    static int subArraySum(int arr[], int tar) {
        int count = 0;
        int n = arr.length;
        // Iterate through all possible subarrays
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Calculate the sum of the subarray starting from index i
            for (int j = i; j < n; j++) {
                currentSum += arr[j]; // Update the current sum
                // Check if the current sum matches the target
                if (currentSum == tar) {
                    count++;
                }

            }

        }
        return count;
    }

    static int subArraySum2(int arr[], int tar) {
        int count = 0; // To store the number of subarrays with sum equal to tar
        int currSum = 0; // To store the cumulative sum
        HashMap<Integer, Integer> sumMap = new HashMap<>(); // To store cumulative sum frequencies

        // Initialize the HashMap with an entry for cumulative sum 0, which helps in
        // counting subarrays that start from index 0
        sumMap.put(0, 1);

        // Traverse the array
        for (int num : arr) {
            // Update the cumulative sum
            currSum += num;

            // Check if (currSum - tar) exists in the map
            if (sumMap.containsKey(currSum - tar)) {
                // Increment count by the number of times (currSum - tar) has appeared
                count += sumMap.get(currSum - tar);
            }

            // Update the map with the current cumulative sum
            sumMap.put(currSum, sumMap.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        System.out.println(subArraySum(new int[] {}, 10));
    }
}
