package com.learn.java.problemsolving;

public class CountingWordsWithaGivenPrefix {
    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"apple", "appetizer", "banana", "application"}, "app"));
        // Expected output: 3 (apple, appetizer, application)
    }

    public static int prefixCount(String[] words, String pref) {
        int result = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(pref) == 0) { // prefix match at position 0
                result++;
            }
        }
        return result;
    }
}
