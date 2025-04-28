package com.learn.java.problemsolving;

public class MaximumDifferenceBetweenEvenandOddFrequencyI {
    public static void main(String[] args) {
        System.out.println(maxDifference(""));
    }

    public static int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int odd = 0;
        int evn = 0;
        for (int i : freq) {
            if (i > 0) {
                if (i % 2 != 0) {
                    odd = Math.max(i, odd);
                } else {
                    evn = Math.min(i, evn);
                }
            }
        }
        return odd - evn;
    }
}
