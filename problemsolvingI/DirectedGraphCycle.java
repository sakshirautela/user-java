
import java.util.ArrayList;

public class DirectedGraphCycle {
    public boolean isCyclic(int n, int[][] edges) {
        // code here
        //int n = adj.size();
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        boolean isVisited[] = new boolean[n];
        boolean reStack[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, isVisited, -1,reStack)) {
                    return true;
                }
        }
        return false;
    }

    private static boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int paraent,boolean[] reStack) {
        if(reStack[i]){
            return true;
        }
        if(isVisited[i]){
            return false;
        }
        isVisited[i] = true;
        reStack[i] = true;
        for (int sub : adj.get(i)) {
            if (dfs(sub, adj, isVisited, i,reStack)) {
                    return true;
                }
                    }
        reStack[i]=false;
        return false;
    }
}
