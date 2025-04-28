package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePathinaTree {
    private List<List<Integer>> tree;
    private int[] distanceFromBob;
    private int n;

    public int mostProfitablePath1(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        distanceFromBob = new int[n];

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        return findPaths(0, 0, 0, bob, amount);
    }

    private int findPaths(int sourceNode, int parentNode, int time, int bob, int[] amount) {
        int maxIncome = 0, maxChild = Integer.MIN_VALUE;
        if (sourceNode == bob) {
            distanceFromBob[sourceNode] = 0;
        } else {
            distanceFromBob[sourceNode] = n;
        }

        for (int adjacentNode : tree.get(sourceNode)) {
            if (adjacentNode != parentNode) {
                maxChild = Math.max(
                        maxChild,
                        findPaths(adjacentNode, sourceNode, time + 1, bob, amount));
                distanceFromBob[sourceNode] = Math.min(
                        distanceFromBob[sourceNode],
                        distanceFromBob[adjacentNode] + 1);
            }
        }
        if (distanceFromBob[sourceNode] > time) {
            maxIncome += amount[sourceNode];
        } else if (distanceFromBob[sourceNode] == time) {
            maxIncome += amount[sourceNode] / 2;
        }

        return (maxChild == Integer.MIN_VALUE) ? maxIncome : maxIncome + maxChild;
    }

    int mx = Integer.MIN_VALUE;

    public void dfs2(ArrayList<Integer> adj[], int s, int p, int pre, int dis[], int disB[], int amount[], int dd) {
        if (disB[s] < dd)
            dis[s] = pre;
        else if (disB[s] == dd)
            dis[s] = pre + amount[s] / 2;
        else
            dis[s] = pre + amount[s];
        for (int i = 0; i < adj[s].size(); i++) {
            if (adj[s].get(i) == p)
                continue;
            dfs2(adj, adj[s].get(i), s, dis[s], dis, disB, amount, dd + 1);
        }
        if (adj[s].size() == 1 && s != 0)
            mx = Math.max(mx, dis[s]);
    }

    boolean dfs(ArrayList<Integer> adj[], int s, int p, int disB[], int pre, int d) {
        if (s == d) {
            disB[s] = pre;
            return true;
        }
        for (int i = 0; i < adj[s].size(); i++) {
            if (adj[s].get(i).intValue() == p)
                continue;
            if (dfs(adj, adj[s].get(i), s, disB, pre + 1, d)) {
                disB[s] = pre;
                return true;
            }
        }
        return false;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        mx = Integer.MIN_VALUE;
        int n = amount.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        int disB[] = new int[n];
        Arrays.fill(disB, Integer.MAX_VALUE);
        int dis[] = new int[n];
        dfs(adj, bob, -1, disB, 1, 0);
        dfs2(adj, 0, -1, 0, dis, disB, amount, 1);
        return mx;
    }
}