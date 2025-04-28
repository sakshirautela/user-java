package com.learn.java.problemsolving;

public class CountOfNumbersWhichAreNotSpecials {
    public static int nonSpecialCount(int l, int r) {
        int res=0;
        for(int i=l;i<=r;i++){
            if(!isSpecila(i)){
                res++;
            }
        }
        return res;
    }
    private static boolean isSpecila(int n) {
        if(n<=2){
            return false;
        }
        int c=0;
        for(int i=2;i<=Math.sqrt(n);i+=2){
            if(n%i==0 && i==Math.sqrt(n)){
                c++;
            }
            else if(n%i==0){
                return false;
            }
        }
        return (c<=1)?false:true;
    }
    public static void main(String args[]){
        System.out.println(nonSpecialCount(5,7));
    }
}