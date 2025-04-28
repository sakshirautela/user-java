package com.learn.java.problemsolving;

public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, usedBits = 0, maxLength = 0;

        for (int r = 0; r < nums.length; r++) {
            while ((usedBits & nums[r]) != 0) {
                usedBits ^= nums[l];
                l++;
            }

            usedBits |= nums[r];
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
/*
 * We need to find the longest "nice" subarray, where:
 * 
 * The bitwise AND of any two elements in the subarray should be zero (i.e., no
 * overlapping bits).
 * This means no two numbers in the subarray should share a '1' bit in the same
 * position.
 * To solve this, we use a sliding window approach:
 * 
 * Expand the window (r) while ensuring the subarray remains "nice".
 * If the condition is violated, shrink the window (l) until the subarray is
 * valid again.
 * Approach
 * Sliding Window Technique
 * 
 * Use two pointers (l and r) to define a valid subarray.
 * Maintain a bitmask (usedBits) to track the OR result of numbers in the
 * current window.
 * If adding nums[r] causes a conflict (usedBits & nums[r] ≠ 0), shrink the
 * window from the left (l).
 * Otherwise, expand the window and update maxLength.
 * Bitwise Operations
 * 
 * usedBits |= nums[r] → Adds the new number’s bits to the mask.
 * usedBits ^= nums[l] → Removes nums[l] when shrinking the window.
 */