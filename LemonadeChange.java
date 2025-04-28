package com.learn.java.problemsolving;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int fiveDoller=0;
        int tenDoller=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fiveDoller++;
            }else if(bills[i]==10){
                if(fiveDoller>0){
                    fiveDoller--;
                    tenDoller++;
                }else{
                    return false;
                }
            }else{
                if(fiveDoller>0 && tenDoller>0){
                    fiveDoller--;
                    tenDoller--;
                }else if(fiveDoller>2){
                    fiveDoller-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(lemonadeChange(new int[]{}));
    }
}