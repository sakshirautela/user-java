package com.learn.java.problemsolving;

public class LongestCommonPrefixAndSuffixgfg {
    public static int lps(String str) {
        // code here
        int res=0;
        int n=str.length();
        for (int i = n-1; i >=1; i--) {
            System.out.println(str.substring(0,i)+" "+str.substring(n-i,n));
            if(str.substring(0,i).equals(str.substring(n-i,n))){
                return i;
            }
        }
        return res;
    }
    int lps2(String str) {
        // code here
        int i=1, j=0, n=str.length();
        int storeLength[]=new int[n];
        while(i<n){
            if(str.charAt(i)==str.charAt(j))storeLength[i++]=++j;
            else if(j>0) j=storeLength[j-1];
            else i++;
        }
        return storeLength[n-1];
    }
    public static void main(String[] args){
        System.out.println(lps("aaa"));
    }
}