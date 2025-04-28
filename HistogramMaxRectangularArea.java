package com.learn.java.problemsolving;

import java.util.Arrays;
import java.util.Stack;

public class HistogramMaxRectangularArea {
    public static void main(String[] args) {
        System.out.println(getMaxArea(new int[] {}));
    }

    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        int res=0;
        getPreviousSmaller(arr, prev, n);
        getNextSmaller(arr, next, n);
        for (int i = 0; i < n; i++) {
            int width=next[i]-prev[i]-1;
            res=Math.max(res,arr[i]*width);
        }
        return res;
    }

    private static void getNextSmaller(int[] arr, int[] next, int n) {
        Arrays.fill(next, n);
        Stack<Integer> st=new Stack<>();
        for (int index=0;index<n;index++) {
            while(!st.isEmpty() && arr[index]<arr[st.peek()]){
               next[st.pop()]=index;
            }
            st.push(index);
        }
    }

    private static void getPreviousSmaller(int[] arr, int[] prev, int n) {
        Arrays.fill(prev, -1);
        Stack<Integer> st=new Stack<>();
        for (int index = 0; index < n; index++) {
            while(!st.isEmpty() && arr[index]<arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                prev[index]=st.peek();
            }
            st.push(index);
        }
    }
}