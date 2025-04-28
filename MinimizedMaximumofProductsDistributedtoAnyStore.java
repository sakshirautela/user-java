package com.learn.java.problemsolving;

public class MinimizedMaximumofProductsDistributedtoAnyStore {
    public static int minimizedMaximum(int n, int[] quantities) {
        int res=0;
        int sum=0;
        for(int i:quantities){
            sum+=i;
        }
        if(sum%n!=0){
            res++;
        }
        return sum/n+res;
    }

    public static void main(String args[]) {
        System.out.println(minimizedMaximum(6, new int[] { 11, 6 }));
    }
}