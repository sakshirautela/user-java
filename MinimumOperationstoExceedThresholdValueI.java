package com.learn.java.problemsolving;

public class MinimumOperationstoExceedThresholdValueI {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{},3));
    }
    public static int minOperations(int[] nums, int k) {
        int res=0;
        for (int i : nums) {
            if(i<k){
                res++;
            }
        }
        return res;
    }
}