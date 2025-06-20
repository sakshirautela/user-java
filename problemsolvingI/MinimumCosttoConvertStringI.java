
// import java.util.ArrayList;
import java.util.Arrays;

public class MinimumCosttoConvertStringI {
    public static void main(String[] args) {
        System.out.println(minimumCost("abcd", "acbe", new char[] { 'a', 'b', 'c', 'c', 'e', 'd' },
                new char[] { 'b', 'c', 'b', 'e', 'b', 'e' }, new int[] { 2, 5, 5, 1, 2, 20 }));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long minCost[][] = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < original.length; i++) {
            int o = original[i] - 'a';
            int c = changed[i] - 'a';
            minCost[o][c] = Math.min(minCost[o][c], (long) cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int s = source.charAt(i) - 'a';
                int t = target.charAt(i) - 'a';
                if (minCost[s][t] >= Integer.MAX_VALUE) {
                    return -1;
                }
                res += minCost[s][t];
            }
        }
        return res;
    }

    public long minimumCost2(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }

        for (int i = 0; i < cost.length; i++) {
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            dis[start][end] = Math.min(dis[start][end], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dis[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE) {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
            }
        }

        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';
            if (dis[a][b] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                ans += (long) dis[a][b];
            }
        }
        return ans;

    }
    // static long[] dp = new long[26];

    // public static long minimumCost(String source, String target, char[] original,
    // char[] changed, int[] cost) {
    // if (source.equals(target)) {
    // return 0;
    // }
    // ArrayList<int[]>[] graph = new ArrayList[26];
    // createGraph(graph, original, changed,cost);
    // for (int i = 0; i < graph.length; i++) {
    // System.out.println(graph[i]);
    // }
    // long sum = 0;
    // for (int i = 0; i < source.length(); i++) {
    // if (source.charAt(i) != target.charAt(i)) {
    // if (dp[source.charAt(i) - 'a'] != 0) {
    // sum += dp[source.charAt(i) - 'a'];
    // } else {
    // boolean[] isVisited = new boolean[26];
    // sum += getLowerCost(graph, source.charAt(i), target.charAt(i), cost, 0,
    // isVisited);
    // }
    // }
    // }
    // return sum;
    // }

    // private static long getLowerCost(ArrayList<int[]>[] graph, char src, char
    // dest, int[] cost, long c,boolean[] isVisited) {
    // if (src == dest) {
    // return dp[src - 'a'] = c;
    // }
    // isVisited[src-'a']=true;
    // for (int i = 0; i < graph[src-'a'].size(); i++) {
    // if(!isVisited[graph[src-'a'].get(i)-'a']){
    // dp[src-'a']=Math.min(dp[src-'a'],getLowerCost(graph, graph[src-'a'].get(i),
    // dest, cost, c+cost[src-'a'], isVisited));
    // }
    // }
    // return 0;
    // }

    // private static void createGraph(ArrayList<int[]>[] graph, char[] original,
    // char[] changed,int[] cost) {
    // for (int i = 0; i < changed.length; i++) {
    // graph[original[i] - 'a']=new int[]{changed[i]-'a',cost[i]};
    // }
    // }
}
