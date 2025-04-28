package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleIV {
    public static void main(String[] args) {
        System.out.println(checkIfPrerequisite(5, new int[][] { {} }, new int[][] { {} }));
    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        Map<Integer, Set<Integer>> nodePrerequisites = new HashMap<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adj : adjList.getOrDefault(node, new ArrayList<>())) {
                nodePrerequisites.computeIfAbsent(adj, k -> new HashSet<>()).add(node);
                for (int prereq : nodePrerequisites.getOrDefault(node, new HashSet<>())) {
                    nodePrerequisites.get(adj).add(prereq);
                }

                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(nodePrerequisites.getOrDefault(query[1], new HashSet<>()).contains(query[0]));
        }
        return answer;
    }

    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = prerequisites.length, m = queries.length;
        if (n == 0) {
            List<Boolean> res = new ArrayList<>(m);
            for (int i = 0; i < m; i++)
                res.add(false);
            return res;
        }
        List<Integer> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int p[] : prerequisites) {
            graph[p[0]].add(p[1]);
        }
        boolean isReachable[][] = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!isReachable[i][i]) { // doing dfs from every node
                dfs(i, graph, isReachable);
            }
        }
        List<Boolean> res = new ArrayList<>(m);
        for (int q[] : queries) {
            res.add(isReachable[q[0]][q[1]]);
        }
        return res;
    }

    private void dfs(int curr, List<Integer> graph[], boolean isReachable[][]) {
        isReachable[curr][curr] = true;
        for (int neigbor : graph[curr]) {
            if (!isReachable[curr][neigbor]) {
                isReachable[curr][neigbor] = true;
                dfs(neigbor, graph, isReachable);
                for (int i = 0; i < isReachable.length; i++) {
                    isReachable[curr][i] |= isReachable[neigbor][i]; // all the nodes
                    // which are reachable from neigbor are reachable from curr as well.
                }
            }
        }
    }
}