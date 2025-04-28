package com.learn.java.problemsolving;

import java.util.HashMap;

public class FindtheNumberofDistinctColorsAmongtheBalls {
    public static void main(String[] args) {
        int[] res=queryResults(5,new int[][]{{}});
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                // Decrement count of the previous color on the ball
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            result[i] = colorMap.size();
        }
        return result;
    }

    public int[] queryResults2(int limit, int[][] queries) {
        HashMap<Integer, Integer> node = new HashMap<>();
        HashMap<Integer, Integer> color = new HashMap<>();
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int it[] = queries[i];
            if (node.containsKey(it[0])) {
                if (node.get(it[0]) == it[1]) {
                    ans[i] = color.size();
                    continue;
                } else if (color.get(node.get(it[0])) <= 1)
                    color.remove(node.get(it[0]));
                else
                    color.put(node.get(it[0]), color.get(node.get(it[0])) - 1);
                node.put(it[0], it[1]);
                color.put(it[1], color.getOrDefault(it[1], 0) + 1);
            } else {
                node.put(it[0], it[1]);
                color.put(it[1], color.getOrDefault(it[1], 0) + 1);
            }
            ans[i] = color.size();
        }
        return ans;
    }
}