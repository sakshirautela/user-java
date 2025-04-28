package com.learn.java.problemsolving;

import java.util.List;
import java.util.ArrayList;

public class PartitonLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels(""));
    }
    public static List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        int partitionEnd = 0, partitionStart = 0;
        List<Integer> partitionSizes = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);
            if (i == partitionEnd) {
                partitionSizes.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return partitionSizes;
    }

    public List<Integer> partitionLabels2(String s) {
        int[] lastOccurrence = new int[26];
        int idx = 0;
        for (char c : s.toCharArray()) {
            lastOccurrence[c - 'a'] = idx;
            idx++;
        }

        List<Integer> ans = new ArrayList<>();
        idx = 0;
        int st = 0, n = s.length();
        while (idx < n) {
            st = getMax(s, lastOccurrence, idx);
            ans.add(st - idx + 1);
            idx = st + 1;
        }
        return ans;
    }

    private int getMax(String str, int[] lastOccurence, int s) {
        int l = Math.max(s, lastOccurence[str.charAt(s) - 'a']), m = l;
        while (s <= Math.max(m, l)) {
            m = Math.max(m, lastOccurence[str.charAt(s) - 'a']);
            s++;
        }
        return m;
    }
}