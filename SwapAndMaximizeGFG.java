package com.learn.java.problemsolving;

import java.util.Arrays;

public class SwapAndMaximizeGFG {
    public static long maxSum(Long[] arr) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        long res=0;
        for (int i = 0; i < n/2; i++) {
            res-=(2*arr[i]);
            res+=(2*arr[n-1-i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new Long[] {}));
    }
}