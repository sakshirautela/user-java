
import java.util.ArrayList;
import java.util.List;

public class MaximumNumberofKDivisibleComponents {
    public static void main(String[] args) {
        System.out.println(maxKDivisibleComponents(5,new int[][]{{}},new int[]{},3));
            }
            public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Step 1: Create adjacency list from edges
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        // Step 2: Initialize component count
        int[] componentCount = new int[1]; // Use array to pass by reference

        // Step 3: Start DFS traversal from node 0
        dfs(0, -1, adjList, values, k, componentCount);

        // Step 4: Return the total number of components
        return componentCount[0];
    }

    private static int dfs(
            int currentNode,
            int parentNode,
            List<Integer>[] adjList,
            int[] nodeValues,
            int k,
            int[] componentCount
    ) {
        int sum = 0;
        for (int neighborNode : adjList[currentNode]) {
            if (neighborNode != parentNode) {
                sum += dfs(
                    neighborNode,
                    currentNode,
                    adjList,
                    nodeValues,
                    k,
                    componentCount
                );
                sum %= k; 
            }
        }
        sum += nodeValues[currentNode];
        sum %= k;
        if (sum == 0) {
            componentCount[0]++;
        }
        return sum;
    }
}
