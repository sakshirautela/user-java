package com.learn.java.problemsolving;

public class MoveAllZeroToEnd {
    static void pushZerosToEnd(int[] arr) {
        // code here
        int nonzero = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[nonzero];
                arr[nonzero]=temp;
                nonzero++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {};
        pushZerosToEnd(new int[] {});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}