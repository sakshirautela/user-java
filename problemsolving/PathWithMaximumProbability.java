
import java.util.ArrayList;

public class PathWithMaximumProbability {
    static class Edge {
        int src;
        int dest;
        double prob;

        Edge(int src, int dest, double prob) {
            this.src = src;
            this.dest = dest;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                    updated = true;
                }
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                    updated = true;
                }
            }
            if (!updated)
                break;
        }

        return maxProb[end_node];
    }

    public static double fun(int n, int[][] edges, double[] succProb, int src, int dest) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(edges, succProb, n, graph);
        boolean[] visited = new boolean[n];
        double prob = 0;
        dfsUtill(visited, src, dest, graph, prob);
        return prob;
    }

    private static void dfsUtill(boolean[] visited, int curr, int dest, ArrayList<Edge>[] graph, double prob) {
        visited[curr] = true;
        System.out.println(curr);
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge a = graph[curr].get(i);
            if (!visited[a.dest]) {
                dfsUtill(visited, a.dest, dest, graph, prob);
            }
        }
    }

    private static void createGraph(int[][] edges, double[] succProb, int n, ArrayList<Edge>[] graph) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[i].add(new Edge(edges[i][0], edges[i][1], succProb[i]));
            graph[i].add(new Edge(edges[i][1], edges[i][0], succProb[i]));
        }
    }

    public static void main(String args[]) {
        fun(3, new int[][] { { 0, 1 }, { 1, 2 }, { 0, 2 } }, new double[] { 0.5, 0.5, 0.2 }, 0, 2);
    }
}
