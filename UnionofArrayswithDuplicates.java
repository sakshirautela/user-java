package com.learn.java.problemsolving;

import java.util.HashSet;

public class UnionofArrayswithDuplicates {
    public static void  main(String args[]){
        System.out.println(findUnion(new int[]{},new int[]{}));
    }
    public static int findUnion(int a[], int b[]) {
        // code here
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i:a){
            hs.add(i);
        }
        for(int i:b){
            hs.add(i);
        }
        return hs.size();
    }
}