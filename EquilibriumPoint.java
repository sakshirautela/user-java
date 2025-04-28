package com.learn.java.problemsolving;

public class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1;
        }

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            long rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i + 1;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        long arr[] = { 1, 3, 5, 2, 2 };
        int n = arr.length;
        System.out.println(equilibriumPoint(arr, n)); // Output: 3
    }
}
