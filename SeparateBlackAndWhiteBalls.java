package com.learn.java.problemsolving;

public class SeparateBlackAndWhiteBalls {
    public static long minimumSteps(String s) {
        int whitePosition = 0;
        long totalSwaps = 0;
        for (int currentPos = 0; currentPos < s.length(); currentPos++) {
            if (s.charAt(currentPos) == '0') {
                totalSwaps += currentPos - whitePosition;
                whitePosition++;
            }
        }
        return totalSwaps;
    }
    public static void main(String args[]){
        System.out.println(minimumSteps("0101"));
    }
}
