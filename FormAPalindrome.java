package com.learn.java.problemsolving;

public class FormAPalindrome {
    public static void main(String args[]){
        System.out.println(countMin(""));
    }
    static int countMin(String str)
    {
        // code here
        int i=0;
        int j=str.length()-1;
        int res=0;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else if(str.charAt(i)!=str.charAt(j)){
                i++;
                j--;
            }
        }
        return res;
    }
}
