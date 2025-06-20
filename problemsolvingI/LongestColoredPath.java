
import java.util.*;

public class LongestColoredPath {
    public static void main(String[] args) {
        // Example input
        String s = "BB";
        int[][] edges = {{1, 2}};
        System.out.println(longestPath(s, edges)); // Output: 2
    }

    public static int longestPath(String s, int[][] edges) {
        int n = s.length();

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Track visited nodes
        boolean[] visited = new boolean[n];
        int[] maxPath = new int[1];

        // Start DFS from every node
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            dfs(i, graph, s, visited, false, 0, maxPath);
        }

        return maxPath[0];
    }

    private static void dfs(int node, List<List<Integer>> graph, String s, boolean[] visited, boolean hasBlue, int length, int[] maxPath) {
        visited[node] = true;
        maxPath[0] = Math.max(maxPath[0], length);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (s.charAt(neighbor) == 'R' && hasBlue) {
                    // Cannot visit red node after visiting a blue node
                    continue;
                }
                dfs(neighbor, graph, s, visited, hasBlue || s.charAt(neighbor) == 'B', length + 1, maxPath);
            }
        }

        // Backtrack
        visited[node] = false;
    }
}
