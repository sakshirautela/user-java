import java.util.*;


public class GraphDirected {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void graohCreation(int v, ArrayList<Edge>[] graph) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 vertex
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 4, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));


    }

    public static void BFS(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                BFSutill(graph, visited);
            }
        }
    }

    public static void BFSutill(ArrayList<Edge>[] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // source vertex
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSutill(graph, i, visited);
            }
        }
    }

    public static void DFSutill(ArrayList<Edge>[] graph, int curr, boolean visted[]) {
        // visit curr
        System.out.print(curr + " ");
        visted[curr] = true;
        // for all the neighbour of the curr
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visted[e.dest]) {
                DFSutill(graph, e.dest, visted);
            }
        }
    }

    public static boolean hashPath(ArrayList<Edge>[] graph, int src, int dest, boolean visted[]) {
        if (src == dest) {
            return true;
        }
        visted[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visted[e.dest] && hashPath(graph, e.dest, dest, visted)) {
                return true;
            }
        }
        return false;
    }

    
    // cycle detection for directrd graph
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtill(graph, visited, i, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtill(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;
        for (int index = 0; index < graph[curr].size(); index++) {
            Edge e = graph[curr].get(index);
            if (stack[e.dest] == true) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycleUtill(graph, visited, e.dest, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        // check the conditions
                        if (col[e.dest] == -1) {
                            col[e.dest] = col[curr] == 0 ? 1 : 0;
                            q.add(e.dest);
                        } else if (col[curr] == col[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // topological sort
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topSortUtill(graph, visited, st, i);
            }
        }
        while (!st.empty()) {
            System.out.println(st.pop());
        }
    }

    private static void topSortUtill(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> st, int curr) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSortUtill(graph, visited, st, e.dest);
            }
        }
        st.add(curr);
    }

    // to print al the paths
    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + " " + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path+" " + src);
        }
    }
    static class dijkstraPair implements Comparable<dijkstraPair>{
        int node;
        int cost;
        dijkstraPair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(dijkstraPair s){
            return this.cost-s.cost;
        }
        
    }
    public static int dijkstra(ArrayList<Edge>[] graph,int src){
        boolean visited[]=new boolean[graph.length];
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<dijkstraPair> pq=new PriorityQueue();
        pq.add(new dijkstraPair(src, 0));
        while (!pq.isEmpty()) {
            dijkstraPair p=pq.remove();
            visited[p.node]=true;
            for (int index = 0; index < graph[p.node].size(); index++) {
                Edge e=graph[p.node].get(index);
                if(!visited[e.dest]){
                    pq.add(new dijkstraPair(e.dest, e.weight));
                    if(dist[e.dest]>(dist[e.src]+e.weight)){
                        dist[e.dest]=dist[e.src]+e.weight;
                    }
                }
            }
        }
        return dist[graph.length-1];

    }
    public static void bellmonFord(ArrayList<Edge>[] graph,int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for (int index = 0; index < V-1; index++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[j].size(); j++) {
                    Edge e=graph[i].get(j);
                    if(dist[e.src] !=Integer.MAX_VALUE && dist[e.dest] > (dist[e.src] + e.weight)) {
                        dist[e.dest] = dist[e.src] + e.weight;
                    }
                }
            }
        }
        for (int index = 0; index < dist.length; index++) {
            System.out.println(dist[index]);
        }
    }
    
    public static void main(String[] args) {
        /*
         * 5 - - -> 0 <- - - 4
         * |        |        |
         * |        |        |
         * |        |        |
         * 2 - - -> 3 - - -> 1
         */
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        //graohCreation(v, graph);
        // BFS(graph);
        // System.out.println();
        // DFS(graph);
        // System.out.println();
        // System.out.println(hashPath(graph, 0, 5, new boolean[v]));
        // System.out.println(hashPath(graph, 0, 7, new boolean[v]));
        // System.out.println(detectCycle(graph));
        // System.out.println(isCycle(graph));
        // System.out.println(isBipartite(graph));
        // topSort(graph);
        // allPath(graph, 5, 1, "");
        // System.out.println(dijkstra(graph, 0));
        // createGraph(graph,v);
        // bellmonFord(graph, 0);
    }

    private static void createGraph(ArrayList<Edge>[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 vertex
        graph[1].add(new Edge(1, 2, -4));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 4, 4));

        // 4 vertex
        graph[4].add(new Edge(4, 1, -1));


    }
}
