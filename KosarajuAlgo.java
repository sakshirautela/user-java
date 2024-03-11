import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        graph[0].add(new Edge(0, 3, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
    }

    public static void topSort(ArrayList<Edge>[] graph, Stack<Integer> s, int curr, boolean visit[]) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                topSort(graph, s, e.dest, visit);
            }
        }
        s.push(curr);
    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean visit[]) {
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                DFS(graph, e.dest, visit);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) {
        boolean visit[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        // step 1
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                topSort(graph, s, i, visit);
            }
        }

        // step 2 //traspose the graph
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            visit[i] = true;
            transpose[i] = new ArrayList();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src, i));
            }
        }
        // step 3 dfs using stack
        while (!s.empty()) {
            int curr = s.pop();
            System.out.print("SCC->");
            DFS(transpose,curr,visit);
            System.out.println(  );
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
