package com.learn.java.problemsolving;

import java.util.Stack;

public class ValidateStackSequences {
    public  static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<Integer>();
        int idx=0;
        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            while (!st.isEmpty() && st.peek()==popped[idx]) {
                st.pop();
                idx++;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        System.out.print(validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
}