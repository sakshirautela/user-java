package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class FindMissingandRepeatedValues {
    public static void main(String[] args) {
        int res[] = findMissingAndRepeatedValues(new int[][] { {} });
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int missing = -1, repeat = -1;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] row : grid) {
            for (int num : row) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        for (int num = 1; num <= n * n; num++) {
            if (!freq.containsKey(num)) {
                missing = num;
            } else if (freq.get(num) == 2) {
                repeat = num;
            }
        }

        return new int[] { repeat, missing };
    }

    public int[] findMissingAndRepeatedValues2(int[][] g) {
        long n = g.length;

        long SN = ((n * n) * ((n * n) + 1)) / 2;
        long S2N = ((n * n) * ((n * n) + 1) * (2 * (n * n) + 1)) / 6;
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                S += g[i][j];
                S2 += (long) g[i][j] * (long) g[i][j];
            }
        }
        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = { (int) x, (int) y };
        return ans;
    }
}