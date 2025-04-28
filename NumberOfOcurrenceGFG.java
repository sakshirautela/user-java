package com.learn.java.problemsolving;

public class NumberOfOcurrenceGFG {
    public static void main(String[] args) {
        System.out.println(countFreq(new int[] {}, 12));
    }

    static int countFreq(int[] arr, int target) {
        // code here
        int freq = 0;
        for (int i : arr) {
            if (i == target) {
                freq++;
            }
        }
        return freq;
    }
}