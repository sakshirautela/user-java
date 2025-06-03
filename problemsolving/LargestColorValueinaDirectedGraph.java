import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueinaDirectedGraph {
    public static void main(String[] args) {
        System.out.println(largestPathValue("", new int[][] { {} }));
    }
    @SuppressWarnings("unchecked")
    public static int largestPathValue(String colors, int[][] edges) {
        
        char[] cs = colors.toCharArray();
        int n = cs.length;
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n;i++) 
           graph[i] = new LinkedList<>();

        int[] indegree = new int[n];
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            indegree[v]++;
            graph[u].add(v);
        }
        
        int[][] count = new int[n][26]; 
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n;i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }
        
        int visited = 0;
        int result = 0;

        while (!que.isEmpty()){
            ++visited;
            int u = que.poll(), color = cs[u] -'a';
            result = Math.max(result, ++count[u][color]);

            for(int v: graph[u]){
                for(int i = 0; i < 26; ++i)
                    count[v][i] = Math.max(count[v][i], count[u][i]);
                
                if(--indegree[v] == 0)
                    que.offer(v);
                
            }
        }
        
        //if visited != n means cycle is there
        return visited == n? result : -1;
    }
    public static int largestPathValue2(String colors, int[][] edges) {
        int n = colors.length();
        int[][] dp = new int[n][26];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        int visit[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n && ans != Integer.MAX_VALUE; i++) {
            ans = Math.max(ans, dfs(visit, i, dp, adj, colors));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int dfs(int[] visit, int src, int[][] dp, List<List<Integer>> adj, String colors) {
        if(visit[src]==1){
            return Integer.MAX_VALUE;
        }
        if(visit[src]==2){
            return dp[src][colors.charAt(src)-'a'];
        }
        visit[src]=1;
        for(int dest:adj.get(src)){
            int res=dfs(visit, dest, dp, adj, colors);
            if(res==Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            for (int i = 0; i <26; i++) {
                dp[src][i]=Math.max(dp[src][i],dp[dest][i]);
            }
        }
        int idx=colors.charAt(src)-'a';
        dp[src][idx]++;
        visit[src]=2;
        return dp[src][idx];
    }
}