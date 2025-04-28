package com.learn.java.problemsolving;

import java.util.Stack;

public class MaximumDifferneces {
    public static int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            left[i] = !st.isEmpty() ? st.peek() : 0;
            st.push(arr[i]);
        }
        st.removeAllElements();
        for (int i = n-1; i >=0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            right[i] = !st.isEmpty() ? st.peek() : 0;
            st.push(arr[i]);

        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(Math.abs(right[i] - left[i]), res);
        }
        return res;

    }

    public static void main(String arga[]) {
        System.out.println(findMaxDiff(new int[] { 2, 4, 8, 7, 7, 9, 3}));
    }
}