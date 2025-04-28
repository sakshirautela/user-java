package com.learn.java.problemsolving;

public class AbsoluteLongestSubarrayWithDiffLimit {
    public static int longestSubarray(int[] nums, int limit) {
        // int left=0;
        // int right=0;
        // int maxel=Integer.MIN_VALUE;
        // int minel=Integer.MAX_VALUE;
        // int result=0;
        // int last=0;
        // while(right<nums.length){
        //     maxel=Math.max(maxel,nums[right]);
        //     minel=Math.min(minel,nums[right]);
        //     if((maxel-minel)>limit){
        //         last=left;
        //         right=left;
        //         maxel=Integer.MIN_VALUE;
        //         minel=Integer.MAX_VALUE;
        //     }else{
        //         last=Math.min(last,left);
        //         right++;
        //         result=Math.max(result,right-left);
        //         left++;
        //     }
        // }
        // return result;
        int left = 0;
        int right = 0;
        int result = 0;
        int maxel = nums[0];
        int minel = nums[0];

        while (right < nums.length) {
            maxel = Math.max(maxel, nums[right]);
            minel = Math.min(minel, nums[right]);

            if (maxel - minel > limit) {
                // Move the left pointer to shrink the window until the condition is satisfied
                left++;
                // Reset the maxel and minel within the current window
                maxel = nums[left];
                minel = nums[left];
                for (int k = left; k <= right; k++) {
                    maxel = Math.max(maxel, nums[k]);
                    minel = Math.min(minel, nums[k]);
                }
            } else {
                // Update the result if the current window is valid
                result = Math.max(result, right - left + 1);
                right++;
            }
        }
        return result;

    }
    public static void main(String[] args){
        System.out.println(longestSubarray(new int[]{8,2,4,7},4));
    }
}