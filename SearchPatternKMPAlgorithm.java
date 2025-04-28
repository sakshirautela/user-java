package com.learn.java.problemsolving;

import java.util.ArrayList;

public class SearchPatternKMPAlgorithm {

    static ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int n=txt.length();
        int m=pat.length();
        ArrayList<Integer> res=new ArrayList<Integer>();
        for (int i = 0; i <n-m+1; i++) {
            if(txt.substring(i,i+m).equals(pat)){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(search("ab", "abcab"));
    }
}