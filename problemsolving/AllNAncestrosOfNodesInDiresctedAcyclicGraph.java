
import java.util.*;

public class AllNAncestrosOfNodesInDiresctedAcyclicGraph {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        ArrayList<Integer>[] graph=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList();
        }
        for (int[] g : edges) {
            graph[g[0]].add(g[1]);
        }
        for (int i = 0; i < n; i++) {
            Dfs(graph,i,i,list,new boolean[n]);
        }
        return list;
    }
    private static void Dfs(ArrayList<Integer>[] graph, int parent,int curr, List<List<Integer>> list,boolean[] visited) {
        visited[curr]=true;
        for(int g:graph[curr]){
            if(!visited[g]){
                list.get(g).add(parent);
                Dfs(graph,parent,g,list,visited);
            }
        }
    }
    public static void main(String[] args){
        System.out.print(getAncestors(8,new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }
}
