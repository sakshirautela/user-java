import java.util.ArrayList;

public class MaximumRequests {
    public static class Edge{
        int src, dst;
        public Edge(int src, int dst){
            this.src = src;
            this.dst = dst;
        }
    }
    
    public static void createGraph(ArrayList<Edge>[] graph,int[][] requests,int n){
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<requests.length;i++){
            int src = requests[i][0];            
            int dest = requests[i][1];
            graph[src].add(new Edge(src, dest));
        }
    }
    // public static int maximumRequests(int n, int[][] requests) {
        
    // }
    public static void printGraph(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                dfs(graph,i,visited,count);
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean[] visited,int count) {
        System.out.print(curr+" ");
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if(!visited[edge.dst]){
                dfs(graph,edge.dst,visited,count);
            }
        }
    }
    public static void main(String[] args) {
        int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        // System.out.println(maximumRequests(n,requests));
        int n=5;
        ArrayList<Edge>[] graph =new ArrayList[n];
        createGraph(graph,requests,n);
        printGraph(graph);
    }
}