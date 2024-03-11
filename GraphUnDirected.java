import java.util.*;

public class GraphUnDirected {
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

    public static void graphCreation(int v, ArrayList<Edge>[] graph) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
        graph[0].add(new Edge(0, 2, 15));

        // 1 vertex
        graph[1].add(new Edge(1, 3, 40));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 50));



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

    // cycle detection for undirected graph
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtill(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtill(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par) {
        visited[curr] = true;
        for (int index = 0; index < graph[curr].size(); index++) {
            Edge e = graph[curr].get(index);
            // case 3
            if (!visited[e.dest]) {
                if (detectCycleUtill(graph, visited, e.dest, curr)) {
                    return true;
                }
            }
            // case 1
            if (visited[e.dest] && par != e.dest) {
                return true;
            }
        }
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
    
    
    public static class primsPair implements Comparable<primsPair>{
        int vertex;
        int cost;
        primsPair(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(primsPair s) {
            return this.cost - s.cost;
        }
    }
    public static int primsAlgoMST(ArrayList<Edge>[] graph,int src){
        int cost=0;
        boolean[] visit=new boolean[graph.length];
        ArrayList<Integer> ans=new ArrayList();
        PriorityQueue<primsPair> pq=new PriorityQueue();
        pq.add(new primsPair(src, 0));
        while (!pq.isEmpty()) {
            primsPair curr=pq.remove();
            if(!visit[curr.vertex]){
                visit[curr.vertex]=true;
                cost+=curr.cost;
                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e=graph[curr.vertex].get(i);
                    if(!visit[e.dest]){
                        pq.add(new primsPair(e.dest, e.weight));
                    }
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        int v = 4;
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
        graphCreation(v, graph);
        System.out.println(primsAlgoMST(graph, 0));
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
