package com.learn.java.problemsolving;

import java.util.ArrayList;

public class UndirectedGraphCycle {
    public static void main(String[] args) {
        System.out.print(isCycle(new ArrayList<>()));
    }

    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        boolean isVisited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if (dfs(i, adj, isVisited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int paraent) {
        isVisited[i] = true;
        for (int sub : adj.get(i)) {
            if (!isVisited[sub]) {
                if (dfs(sub, adj, isVisited, i)) {
                    return true;
                }
            } else if (isVisited[sub] && sub != paraent) {
                return true;
            }
        }
        return false;
    }
}