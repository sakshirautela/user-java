package com.learn.java.problemsolving;

public class MinimumDeletionToMakeStringBalanced {
    public static int minimumDeletions(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        int b=0;
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)=='b'){
                dp[i]=dp[i-1];
                b++;
            }else{
                dp[i]=Math.min(dp[i-1]+1,b);
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        System.out.println(minimumDeletions("aababbab"));
    }
}
