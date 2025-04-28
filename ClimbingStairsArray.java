package com.learn.java.problemsolving;

import java.util.ArrayList;

public class ClimbingStairsArray {
    public static int solve(ArrayList<Integer> A) {
        int n = A.size();

        int steps = -1;

        int first = A.get(0);

        int second = first + A.get(1);

        for (int i = 2; i < n; i++) {
            steps = Math.min(first, second) + A.get(i);
            first = second;
            second = steps;
        }

        return second;
    }

    public static void main(String args[]) {
        ArrayList<Integer> al = new ArrayList();
        al.add(4);
        System.out.println(solve(al));
    }
}