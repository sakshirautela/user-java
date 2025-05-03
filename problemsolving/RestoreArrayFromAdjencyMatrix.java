import java.util.*;

public class RestoreArrayFromAdjencyMatrix {

    @SuppressWarnings("unused")
    public int[] restoreArray(int[][] adjacentPairs) {
        // Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        // Find the starting point (a node with only one neighbor)
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        // Reconstruct the array using DFS
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();
        dfs(graph, start, visited, result, 0);

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int curr, Set<Integer> visited, int[] result, int idx) {
        result[idx] = curr;
        visited.add(curr);

        for (int neighbor : graph.get(curr)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, result, idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        RestoreArrayFromAdjencyMatrix solver = new RestoreArrayFromAdjencyMatrix();
        int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(solver.restoreArray(adjacentPairs))); // Output: [1, 2, 3, 4]
    }
}
