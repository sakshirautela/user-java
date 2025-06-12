import java.util.ArrayList;
import java.util.Arrays;

public class CountThePathsToReachSrcTodest {
    public static void main(String[] args) {
        System.out.println(countPaths(new int[][] { {} }, 4, 2, 3));
    }

    public static int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dp=new int[V];
        Arrays.fill(dp,-1);
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
        return dfs(src,-1,dest,graph,dp);
    }

    private static int dfs(int src, int par, int target, ArrayList<ArrayList<Integer>> graph, int[] dp) {
        if(src==target){
            return 1;
        }
        if(dp[src]!=-1){
            return dp[src];
        }
        int res=0;
        for (int   dest: graph.get(src)) {
            if(dest==par){
                continue;
            }
            res+=dfs(dest, par, target, graph, dp);
        }
        return dp[src]=res;
    }
}