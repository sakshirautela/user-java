package com.learn.java.problemsolving;

public class TransformArraybyParity {
    public static void main(String[] args) {
        int[] res=transformArray(new int[]{4,3,2,1});
        for(int i:res){
            System.out.print(i+" ");
        }
    }
    public static int[] transformArray(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                idx++;
                nums[idx]=0;
            }
        }
        for (int i = idx+1; i < n; i++) {
            nums[i]=1;
        }
        return nums;
    }
}