package com.learn.java.problemsolving;

public class NumberofSubArraysWithOddSum {

    public static int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;  // To handle large numbers and avoid overflow
        int count = 0;  // To store the final count of subarrays with an odd sum
        int prefixSum = 0;  // To store the running sum of the elements
        int oddCount = 0;  // To track the count of odd prefix sums
        int evenCount = 1;  // To track the count of even prefix sums (initialized to 1 for the empty subarray)

        // Loop through each number in the array
        for (int num : arr) {
            // Update the prefix sum by adding the current number
            prefixSum += num;

            // If the current prefix sum is even, we add the count of odd prefix sums
            // If the prefix sum is odd, we add the count of even prefix sums
            if (prefixSum % 2 == 0) {
                count += oddCount;  // Add the number of odd prefix sums
                evenCount++;  // Increment even count
            } else {
                count += evenCount;  // Add the number of even prefix sums
                oddCount++;  // Increment odd count
            }

            // Keep the count within the range of the MOD value
            count %= MOD;
        }

        return count;  // Return the total count of subarrays with an odd sum
    }

    // Main function to test the above solution
    public static void main(String[] args) {
        // Test with an example input
        int[] arr = {1, 3, 5};
        System.out.println(numOfSubarrays(arr));  // Output should be 4
    }
}