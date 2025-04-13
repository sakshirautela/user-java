import java.util.ArrayList;
import java.util.Stack;

public class TopSortGFG {
    public static void main(String[] args) {
        System.out.println(topoSort(4, new int[][] { { 3, 0 }, { 1, 0 }, { 2, 0 } }));
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSortHelepr(i, graph, visited, st);
            }
        }
        while (!st.isEmpty()) {
            li.add(st.pop());
        }
        return li;
    }

    private static void topoSortHelepr(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
            Stack<Integer> st) {
        visited[i] = true;
        for (int dest : graph.get(i)) {
            if (!visited[dest]) {
                topoSortHelepr(dest, graph, visited, st);
            }
        }
        st.push(i);
    }
}