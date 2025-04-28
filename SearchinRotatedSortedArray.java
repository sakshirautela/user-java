package com.learn.java.problemsolving;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{},12));
    }
    static int search(int[] arr, int key) {
        // Complete this function
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}