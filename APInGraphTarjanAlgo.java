import java.util.ArrayList;

public class APInGraphTarjanAlgo { //Articulation Point
    static class Edge {
        int src;
        int dest;
        // int wt;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }

    }

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 3));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void tarjanAlgo(ArrayList<Edge>[] graph, int V) {
        boolean visited[] = new boolean[V];
        boolean al[] = new boolean[V]; //to remove duplicacy
        int low[] = new int[V];
        int dt[] = new int[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                tarjanAlgoUtill(graph, visited, i, -1, low, dt, time,0,al);
            }
        }
        System.out.print("Ap ar e - ");
        for (int i = 0; i < V; i++)   {
            if(al[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static void tarjanAlgoUtill(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par, int low[],
            int dt[], int t,int child,boolean[] al) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++t;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            } else if (!visited[e.dest]) {
                tarjanAlgoUtill(graph, visited, e.dest, curr, low, dt, t,child,al);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (par!=-1 && dt[curr] <= low[e.dest]) {
                    al[curr]=true;
                }
                child++;

            } 
            else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
        if(par==-1 && child>1){
            al[curr]=true;
        }

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        tarjanAlgo(graph, V);
    }
}
