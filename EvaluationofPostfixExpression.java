package com.learn.java.problemsolving;

import java.util.Stack;

public class EvaluationofPostfixExpression {
    public static void main(String[] args) {
        System.out.println(evaluate(new String[] {}));
    }

    public static int evaluate(String[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        for (String  ch : arr) {
            if(ch.equals("*")) {
                int a=st.pop();
                int b=st.pop();
                st.push(b*a);
            }
            else if(ch.equals("+")){
                int a=st.pop();
                int b=st.pop();
                st.push(b+a);
            }else if(ch.equals("-")){
                int a=st.pop();
                int b=st.pop();
                st.push(b-a);
            } else if(ch.equals("/")){
                int a=st.pop();
                int b=st.pop();
                st.push(b/a);
            }else{
                st.push(Integer.parseInt(ch));
            }   
        }
        return st.pop();
    }
}