package com.learn.java.problemsolving;

public class MinimumBitFlipstoConvertNumber {
    public static int  minBitFlips(int start, int goal) {
        start=start^goal;
        int res=0;
        while(start>0){
            res+=start%2==1?1:0;
            start/=2;
        }
        return res;
    }
    public static int minBitFlips2(int start, int goal) {
        int res = 0;

        while (start > 0 || goal > 0) {
            int rightStart = (start & 1);
            int rightGoal = (goal & 1);

            res += rightStart != rightGoal ? 1 : 0;
            
            start = start > 0 ? start >> 1 : 0;
            goal = goal > 0 ? goal >> 1 : 0;

        }


        return res;
    }
    public static void main(String args[]){
        System.out.println(minBitFlips(10,7));
    }
}