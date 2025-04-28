package com.learn.java.problemsolving;

public class StoneGameI {
    public static boolean stoneGame(int[] piles) {
        int i=0;
        int j=piles.length-1;
        int alice=0;
        int bob=0;
        boolean r=true;
        while(i<j){
            if(r){
                if(piles[i]>piles[j]){
                    alice+=piles[i];
                    i++;
                }else{
                    alice+=piles[j];
                    j--;
                }
                r=!r;
            }else{
                if(piles[i]<piles[j]){
                    bob+=piles[i];
                    i++;
                }else{
                    bob+=piles[j];
                    j--;
                }
                r=!r;
            }
        }
        if(alice>bob){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{3,7,2,3}));
    }
}