import java.util.*;

public class CheapestFlightsWithKStops {
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

     
    public static void graphCreation(int v, ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Info{
        int v;
        int cost;
        int stops;
        Info(int v,int c,int k){
            this.v=v;
            this.cost = c;
            this.stops=k;
        }
    }
    public static int cheapestFlightsWithKStops(int src,int dest,int k,ArrayList<Edge>[] graph){
        int[] dist=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info> q=new LinkedList();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[ curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.weight;
                if( dist[v]>curr.cost+wt && curr.stops<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v,dist[v], curr.stops+1));
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        }
    }
    public static void main(String[] args) {
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        ArrayList<Edge>[] graph =new ArrayList[flights.length];
        graphCreation(flights.length,graph,flights);
        System.out.println(cheapestFlightsWithKStops(0,3,1,graph));
    }
}
