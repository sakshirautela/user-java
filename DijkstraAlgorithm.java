import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void main(String[] args) {

    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }
        int distance[] = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { src, 0 });
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            if(d>distance[u]) continue;
            
            for(int[] neighbor : graph.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];
                
                if(distance[u]+w<distance[v]){
                    distance[v]= distance[u]+w;
                    pq.add(new int[]{v,distance[v]});
                }
            }
        }
        return distance;
    }
}