package com.learn.java.problemsolving;

public class CircularSentences {
    public static boolean isCircularSentence(String sentence) {
        String words[] = sentence.split(" ");
        int n = words.length;

        char last = words[n - 1].charAt(words[n - 1].length() - 1);

        for (int i = 0; i < n; i++) {
            if (words[i].charAt(0) != last)
                return false;
            last = words[i].charAt(words[i].length() - 1);
        }

        return true;
    }

    public boolean isCircularSentence2(String sentence) {
        String words[] = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        if (words.length == 1) {
            return words[0].charAt(0) == words[0].charAt((words[0].length() - 1));
        }
        return words[0].charAt(0) == words[words.length - 1].charAt((words[words.length - 1].length() - 1));
    }

    public boolean isCircularSentence3(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        int k = s.indexOf(" ");
        if (k == -1)
            return true;

        while (k != -1) {
            if (s.charAt(k - 1) != s.charAt(k + 1)) {
                return false;
            }

            k = s.indexOf(" ", k + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
    }
}