package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class StockSpanProblem {
    public static void main(String[] args) {
        System.out.println(calculateSpan(new int[] {}));
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        int n=arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            int count=1;
            int idx=i-1;
            while(idx>=0 && arr[i]<=arr[idx] ){
                idx--;
                count++;
            }
            al.add(count);
        }
        return al;
    }
    static ArrayList<Integer> calculateSpan2(int[] arr) {

        int n = arr.length; 
        ArrayList<Integer> span = new ArrayList<>(Collections.nCopies(n, 0));  
        Stack<Integer> stk = new Stack<>();  

        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && arr[stk.peek()] <=arr[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                span.set(i, (i + 1));
            } else {
                span.set(i, (i - stk.peek()));
            }
            stk.push(i);
        }

        return span;
    }
}