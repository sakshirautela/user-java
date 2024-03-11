import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgo {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge s) {
            return this.wt-s.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    public static int n = 4;
    public static int[] par = new int[n];
    public static int[] rank = new int[n]; // fill all with 0 (by default)

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    // public static int find(int x) {
    // if (x == par[x]) {
    // return x;
    // }
    // return find(par[x]);
    // }

    public static int pathCompressed(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = pathCompressed(par[x]);
    }

    public static void union(int a, int b) {
        int parA = pathCompressed(a);
        int parB = pathCompressed(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static int kruskalMST(ArrayList<Edge> graph,int v){
        Collections.sort(graph); //O(ElogE)
        int count=0;
        int mstCost=0;
        for(int i=0;count<v-1;i++){ //O(V)
            Edge e=graph.get(i);
            int parA = pathCompressed(e.src);
            int parB = pathCompressed(e.dest);
            if(parA!=parB){
                union(e.src,e.dest);
                count++;
                mstCost+=e.wt;
            }
        }
        return mstCost;

    }

    public static void main(String[] args) {
        init();
        ArrayList<Edge> graph = new ArrayList();
        createGraph(graph);
        int v = 4;//graph.size() - 1;
        System.out.println(kruskalMST(graph,v));
    }
}
