package com.learn.java.problemsolving;

import java.util.HashSet;

public class OptimalPartitionofString {
    public static void main(String[] args) {
        System.out.println(partitionString(""));
    }

    public static int partitionString(String s) {
        int count = 1;
        HashSet<Character> hs = new HashSet<Character>();
        for (char ch : s.toCharArray()) {
            if (hs.contains(ch)) {
                count++;
            }
                hs.add(ch);
        }
        return count;
    }

    public int partitionString2(String s) {
        int x = 0, ans = 1;

        for (char ch : s.toCharArray()) {
            if ((x & (1 << ch)) != 0) {
                x = 0;
                ans++;
            }
            x ^= 1 << ch;
        }
        return ans;
    }
}
