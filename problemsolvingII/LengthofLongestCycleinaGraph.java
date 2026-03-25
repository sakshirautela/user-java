import java.util.ArrayList;
import java.util.Stack;

public class LengthofLongestCycleinaGraph {
    static void main() {
        int[][] edges = {{0, 5}, {1, 0}, {2, 4}, {3, 1}, {4, 6}, {5, 6}, {6, 3}};
        int v = 7;
        System.out.println(longestCycle(v, edges));
    }

    public static int longestCycle(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        makegraph(edges, graph, V);
        boolean[] visited = new boolean[V];
        return dfsCount(graph, V, visited);
    }

    private static int dfsCount(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited) {
        int count = -1;
        boolean[] temp = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count = Math.max(count, dfsCountUtil(graph, i, visited, 0, temp));
            }
        }
        return count;
    }

    private static int dfsCountUtil(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, int level, boolean[] stack) {
        if(stack[src]) {
            return level;
        }
        if(visited[src]) {
            return -1;
        }
        int count = -1;
        for (int dest : graph.get(src)) {
            if (!stack[dest]) {
                count = dfsCountUtil(graph, dest, visited, level + 1, stack);
            }
        }
        stack[src] = false;
        return count;
    }

    private static void makegraph(int[][] edges, ArrayList<ArrayList<Integer>> graph, int v) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
    }

}
