package com.learn.java.problemsolving;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[] {}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int prefixSum = 0,currSum=0;
        int chunks=0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum+=arr[i];
            currSum+=i;
            if(prefixSum==currSum){
                chunks++;
            }
        }
        return chunks;
    }
}