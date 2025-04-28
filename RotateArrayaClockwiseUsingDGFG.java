package com.learn.java.problemsolving;

public class RotateArrayaClockwiseUsingDGFG {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        int[] temp = new int[arr.length];
        int n = arr.length;
        int idx = 0;
        for (int i = d % n; i < n; i++) {
            temp[idx++] = arr[i];
        }
        for (int i = 0; i < d % n; i++) {
            temp[idx++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // User function Template for Java

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr2(int arr[], int d) {
        int n = arr.length;
        d = d % n; // Handle cases where d > n

        // Step 1: Reverse the first part
        reverse(arr, 0, d - 1);

        // Step 2: Reverse the second part
        reverse(arr, d, n - 1);

        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        int[] res = { 7, 3, 1, 9 };
        rotateArr(res, 9);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}