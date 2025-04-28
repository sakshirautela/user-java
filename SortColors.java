package com.learn.java.problemsolving;

public class SortColors {
    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public static void sortColors(int[] nums) {
        int mid=0;
        int low=0;
        int high=nums.length-1;
        while(high>=mid){
            if(nums[mid]==0){
                swap(nums,mid,low);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                    high--;
            }
            
        }
    }
    public static void main(String args[]){
        sortColors(new int[]{0,1,2,1,0});
    }
}