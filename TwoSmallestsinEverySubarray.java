package com.learn.java.problemsolving;

public class TwoSmallestsinEverySubarray {
    public static <Stirng> void main(Stirng args[]){
        
    }
    public int pairWithMaxSum(int[] arr) {
        // code here
        int sum = -1;
        for(int i = 1; i < arr.length; i++){
            sum = Math.max(sum, arr[i-1] + arr[i]);
        }
        return sum;
    }
}
