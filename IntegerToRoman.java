package com.learn.java.problemsolving;

public class IntegerToRoman {
    public static String intToRoman(int n) {
        String s="";
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<val.length;i++){
            while(n>=val[i]){
                n-=val[i];
                s+=roman[i];
            }
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(1005));
    }
}