package com.learn.java.problemsolving;

import java.util.Arrays;

public class NonOverlapingIntervalsGFG {
    static int minRemoval(int intervals[][]) {
        // code here
        int res=0;
        Arrays.sort(intervals);
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if (intervals[i][0] < end) {
                res++;
                end = Math.min(intervals[i][1], end);
            }else{
                end = intervals[i][1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(minRemoval(new int[][]{{}}));
    }
}
