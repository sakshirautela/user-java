package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DivideNodesIntotheMaximumNumberofGroups {

    // Main function to calculate the maximum number of groups for the entire graph
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] parent = new int[n];
        int[] depth = new int[n];
        Arrays.fill(parent, -1);

        // Build the adjacency list and apply Union-Find for each edge
        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
            union(edge[0] - 1, edge[1] - 1, parent, depth);
        }

        Map<Integer, Integer> numOfGroupsForComponent = new HashMap<>();

        // For each node, calculate the maximum number of groups for its component
        for (int node = 0; node < n; node++) {
            int numberOfGroups = getNumberOfGroups(adjList, node, n);
            if (numberOfGroups == -1) return -1; // If invalid split, return -1
            int rootNode = find(node, parent);
            numOfGroupsForComponent.put(
                rootNode,
                Math.max(
                    numOfGroupsForComponent.getOrDefault(rootNode, 0),
                    numberOfGroups
                )
            );
        }

        // Calculate the total number of groups across all components
        int totalNumberOfGroups = 0;
        for (int numberOfGroups : numOfGroupsForComponent.values()) {
            totalNumberOfGroups += numberOfGroups;
        }
        return totalNumberOfGroups;
    }

    // Function to calculate the number of groups for a given component starting from srcNode
    private int getNumberOfGroups(
        List<List<Integer>> adjList,
        int srcNode,
        int n
    ) {
        Queue<Integer> nodesQueue = new LinkedList<>();
        int[] layerSeen = new int[n];
        Arrays.fill(layerSeen, -1);
        nodesQueue.offer(srcNode);
        layerSeen[srcNode] = 0;
        int deepestLayer = 0;

        // Perform BFS to calculate the number of layers (groups)
        while (!nodesQueue.isEmpty()) {
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    // If neighbor hasn't been visited, assign it to the next layer
                    if (layerSeen[neighbor] == -1) {
                        layerSeen[neighbor] = deepestLayer + 1;
                        nodesQueue.offer(neighbor);
                    } else {
                        // If the neighbor is already in the same layer, return -1 (invalid partition)
                        if (layerSeen[neighbor] == deepestLayer) {
                            return -1;
                        }
                    }
                }
            }
            deepestLayer++;
        }
        return deepestLayer;
    }

    // Find the root of the given node in the Union-Find structure
    private int find(int node, int[] parent) {
        while (parent[node] != -1) node = parent[node];
        return node;
    }

    // Union operation to merge two sets
    private void union(int node1, int node2, int[] parent, int[] depth) {
        node1 = find(node1, parent);
        node2 = find(node2, parent);

        // If both nodes already belong to the same set, no action needed
        if (node1 == node2) return;

        // Union by rank (depth) to keep the tree balanced
        if (depth[node1] < depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }
        parent[node2] = node1;

        // If the depths are equal, increment the depth of the new root
        if (depth[node1] == depth[node2]) depth[node1]++;
    }
    public int magnificentSets2(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        n++;
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int edg[] : edges)
        {
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }

        if(!isBipartite(adj, n))
            return -1;

        int degreeBFS[] = new int[n];
        for(int i = 1; i < n; i++)
            degreeBFS[i] = bfsdegree(adj, i);

        int vis[] = new int[n];
        int grp = 0;
        for(int i = 1; i < n; i++)
            if(vis[i] == 0)
                grp += dfs(adj, vis, degreeBFS, i);

        return grp;
    }

    public int dfs(List<List<Integer>> adj,int vis[], int deg[], int vertex) {
        vis[vertex] = 1;
        int componentMax = deg[vertex];
        for(int ver : adj.get(vertex))
            if(vis[ver] == 0)
                componentMax = Math.max(componentMax, dfs(adj, vis, deg, ver));
        return componentMax;
    }

    public int bfsdegree(List<List<Integer>> adj, int vertex) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{vertex, 1});
        int vis[] = new int[adj.size()];
        vis[vertex] = 1;
        int ele[] = new int[2];
        while(!q.isEmpty())
        {
            ele = q.poll();
            for(int ver : adj.get(ele[0]))
                if(vis[ver] == 0)
                {
                    vis[ver] = 1;
                    q.add(new int[]{ver, ele[1] + 1});
                }
        }
        return ele[1];
    }

    public boolean isBipartite(List<List<Integer>> adj, int n) {
        int color[] = new int[n];
        for(int i = 0; i < n; i++)
            if(color[i] == 0 && !bfs(adj, color, i))
                return false;
        return true;
    }

    public boolean bfs(List<List<Integer>> adj, int color[], int vertex) {
        color[vertex] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        while(!q.isEmpty())
        {
            int ele = q.poll();
            int col = color[ele] == 1 ? 2 : 1;
            for(int ver : adj.get(ele))
                if(color[ver] == 0)
                {
                    color[ver] = col;
                    q.add(ver);
                }
                else if(color[ver] != col)
                    return false;
        }
        return true;
    }
}