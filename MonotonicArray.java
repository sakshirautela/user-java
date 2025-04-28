package com.learn.java.problemsolving;

import java.util.Arrays;

public class MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        int n=nums.length;
        int[] sort=Arrays.copyOf(nums,n);
        Arrays.sort(sort);
        return getIncreseaing(nums,sort,n) || getDecreasing(nums,sort,n);
    }
    public static boolean getIncreseaing(int[] nums,int[]sort,int n){
        for (int i = 0; i < n; i++) {
            if(nums[i]!=sort[i]){
                return false;
            }        
        }
        return true;
    }
    public static boolean getDecreasing(int[] nums,int[]sort,int n){
        for (int i = 0; i < n; i++) {
            if(nums[i]!=sort[n-i-1]){
                return false;
            }        
        }
        return true;
    }

    public static boolean isMonotonic2(int[] nums) {
        int n=nums.length;
        if(nums[0]<nums[n-1]){
            for(int i=1;i<n;i++){
                if(nums[i-1]>nums[i]){
                    return false;
                }
            }
        }else{
            for(int i=1;i<n;i++){
                if(nums[i-1]<nums[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isMonotonic2(new int[]{1,2,2,3}));
    }
}