package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class FindValidPairofAdjacentDigitsinString {
    public static void main(String[] args) {
        System.out.println(findValidPair(""));
    }

    public static String findValidPair(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char firstDigit = s.charAt(i);
            char secondDigit = s.charAt(i + 1);
            if (firstDigit != secondDigit) {
                if (freq.get(firstDigit) == Character.getNumericValue(firstDigit) &&
                    freq.get(secondDigit) == Character.getNumericValue(secondDigit)) {
                    return String.valueOf(firstDigit) + secondDigit;
                }
            }
        }
        return "";
    }
}