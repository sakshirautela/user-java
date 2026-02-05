import java.util.ArrayList;
import java.util.Arrays;

public class SumOfDistanceInTree {
    static void main() {
        int[] arr = sumOfDistancesInTree(4, new int[][]{{}});
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] dp = new int[n][n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] distance = new int[n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int i = 0; i < n; i++) {
        int a=0;
            for (int j = 0; j < n; j++) {
                if(i!=j || dp[i][j]==-1){
                    dp[i][j]=dfs3(i,j,-1,0,graph,dp);
                }
                dp[i][j]=dp[j][i];
                a+=dp[i][j];
            }
            distance[i]=a;
            //distance[i] = dfs(i, distance, 0, graph, -1, dp);
        }
        return distance;
    }

    private static int dfs3(int src, int dest,int par, int dist, ArrayList<ArrayList<Integer>> graph, int[][] dp) {
        if(src==dest){
            return dist;
        }
        int res=0;
        for(int neigh:graph.get(src)){
            if(par!=neigh){
                res=dfs3(neigh,dest,src,dist+1,graph,dp);
            }
        }
        return res;
    }

    private static int dfs(int src, int[] distance, int dist, ArrayList<ArrayList<Integer>> graph, int visited, int[][] dp) {
        int a = dist;
        //visited[src]=true;
        for (int dest : graph.get(src)) {
            if (visited != dest) {
                if (dp[src][dest] != 0) {
                    a += dp[src][dest];
                } else {
                    a += dfs(dest, distance, dist + 1, graph, src, dp);
                    dp[src][dest] = a;
                }
            }
        }
        return a;
    }
}