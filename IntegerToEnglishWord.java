package com.learn.java.problemsolving;

public class IntegerToEnglishWord {
    private static final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] belowTwenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] belowHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    public static void main(String args[]){
        System.out.println(numberToWords(143));
    }
    public static String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        return numberToWordsHeleper(num);
    }
    public static String numberToWordsHeleper(int n) {
        if(n<10){
            return belowTen[n];
        }
        if(n<20){
            return belowTwenty[n-10];
        }
        if(n<100){
            return belowHundred[n/10]+" "+belowTen[n%10];
        }
        if(n<1000){
            return belowTen[n/100]+" "+"Hundred "+numberToWordsHeleper(n%100);
        }
        if(n<100000){
            return belowTen[n/10000]+" "+"Thousand "+numberToWordsHeleper(n%100);
        }if(n<1000000){
            return belowTen[n/100000]+" "+"Million "+numberToWordsHeleper(n%100);
        }
        return belowTen[n/100000000]+" "+"Hundred "+numberToWordsHeleper(n%100);
    }
}
