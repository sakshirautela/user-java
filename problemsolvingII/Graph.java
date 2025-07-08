import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {
    public static void main(String[] args){
        int n=4;
        int[][] edges= {{0,1},{1,2}};
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        createGraph(edges,graph,n);
        dfs(graph,n);
    }

    
    private static void createGraph(int[][] edges, ArrayList<ArrayList<Integer>> graph, int n) {
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    private static void dfs(ArrayList<ArrayList<Integer>> graph, int n) {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfsUtil(i,graph,visited);
            }
        }
    }


    private static void dfsUtil(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node]=true;
        System.out.println(node);
        for(int child:graph.get(node)){
            if(!visited[child]){
                dfsUtil(child,graph,visited);
            }
        }
    }
    @SuppressWarnings("unused")
    private static void bfs(ArrayList<ArrayList<Integer>> graph, int n) {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfsUtil(i,graph,visited);
            }
        }
    }


    private static void bfsUtil(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(node);
        while(!pq.isEmpty()){
            
        }
    }
}
