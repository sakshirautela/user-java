package com.learn.java.problemsolving;

public class SubArraySumDivisbleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int res=0;
        for(int i=0;i<nums.length-1;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
            }
            if(sum%k==0){
                res++;
            }
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
}