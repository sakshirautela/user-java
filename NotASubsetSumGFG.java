package com.learn.java.problemsolving;

public class NotASubsetSumGFG {
    public static long findSmallest(int[] arr) {
        // Your code goes here
        long min=1;
        long prefix=0;
        for(int i:arr){
            if(i==min){
                min++;
            }
            prefix+=i;
            if(min==prefix){
                min++;
            }
        }
        return min;
    }
    public static void main(String[] args){
        System.out.println(findSmallest(new int[]{1,2,3}));
    }
}