package com.learn.java.problemsolving;

import java.util.HashMap;

public class FirstCompletelyPaintedRoworColumn {
    public static void main(String ragsp[]) {
        System.out.println(firstCompleteIndex(new int[] { 1, 3, 4, 2 }, new int[][] { { 1, 4 }, { 2, 3 } }));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> hm = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hm.put(mat[i][j], new int[] { i, j });
            }
        }
        System.out.println(hm);
        for (int i = 0; i < arr.length; i++) {
            int[] idx = hm.get(arr[i]);
            mat[idx[0]][idx[1]] = 0;
            if (isPaintedRow(mat, idx[0]) || isPaintedCol(mat, idx[1])) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isPaintedRow(int[][] mat, int row) {
        // Return true if row is completely seen
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPaintedCol(int[][] mat, int col) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    public int firstCompleteIndex2(int[] arr, int[][] mat) {
        int[] map = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] = i;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int max = 0;
            for (int j = 0; j < mat[i].length; j++) {
                max = Math.max(max, map[mat[i][j]]);
            }
            ans = Math.min(ans, max);
        }
        for (int i = 0; i < mat[0].length; i++) {
            int max = 0;
            for (int j = 0; j < mat.length; j++) {
                max = Math.max(max, map[mat[j][i]]);
            }
            ans = Math.min(ans, max);
        }
        return ans;
    }
}