package com.learn.java.problemsolving;

public class NthNaturalNumber {
    static long findNth(long n) {
        // code here
        if(n<9){
            return n;
        }
        long digit=1;
        while(n>1){
            if(isDigitNine(digit)){
                digit++;
            }else{
                digit++;
                n--;
            }
        }
        return digit;
    }
    private static boolean isDigitNine(long digit) {
        while(digit>0){
            long rem=(digit%10);
            if(rem==9){
                return true;
            }
            digit/=10;
        }
        if(isDigitNine(digit)){
            digit++;
        }
        return false;
    }
    static long findNth2(long n) {
        long res=0;
        long p=1;
        while (n>0) {
            res+=(p*(n%9));
            n/=9;
            p*=10;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(findNth2(99));
    }
}