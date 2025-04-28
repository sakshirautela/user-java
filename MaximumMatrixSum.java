package com.learn.java.problemsolving;

public class MaximumMatrixSum {
    public static long maxMatrixSum(int[][] matrix) {
        int len = matrix.length;
        int neg = 0;
        int min_abs = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] < 0) {
                    neg++;
                }
                min_abs = Math.min(min_abs, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (neg % 2 == 0) {
            return sum;
        }
        return sum - (min_abs) - min_abs;
    }

    public long maxMatrixSum2(int[][] matrix) {
        long s = 0;
        int r = matrix.length;
        int m = Integer.MAX_VALUE;
        boolean n = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                int v = matrix[i][j];
                if (v < 0) {
                    n = !n;
                    v = -v;
                }
                s += v;
                if (v < m) {
                    m = v;
                }
            }
        }
        if (n)
            return s - m * 2;
        return s;
    }

    public static void main(String[] args) {
        System.out.println(maxMatrixSum(new int[][] { {} }));
    }
}
