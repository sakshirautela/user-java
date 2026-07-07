package problemsolvingIII;

import java.util.ArrayList;
import java.util.List;

public class MinimumScoreofaPathBetweenTwoCities {
    static void main() {
        System.out.println();
    }

    public int minScoreUnionAndFind(int n, int[][] roads) {
        int[] parents = new int[n+1];
        int[] ranks = new int[n+1];
        for(int i=1;i<=n;i++){
            parents[i]=i;
            ranks[i]=Integer.MAX_VALUE;
        }
        for(int[] road:roads){
            minScoreUnion(road[0],road[1],road[2],parents,ranks);
        }
        return ranks[minScoreFind(1,parents)];
    }

    private int minScoreFind(int s, int[] parents) {
        while (parents[s]!=s){
            parents[s]=parents[parents[s]];
            s=parents[s];
        }
        return s;
    }

    private void minScoreUnion(int src, int dest, int weight, int[] parents, int[] ranks) {
        int s=minScoreFind(src, parents);
        int d=minScoreFind(dest, parents);
        if(s!=d){
            parents[s]=d;
            ranks[d]=Math.min(ranks[s],Math.min(ranks[d],weight));
        }else{
            ranks[s]=Math.min(ranks[s],weight);
        }
    }

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n];
        return dfsMinScore(visited, adj, 1);
    }

    private int dfsMinScore(boolean[] visited, List<List<int[]>> adj, int src) {
        visited[src] = true;
        int min = Integer.MAX_VALUE;
        for (int[] dest : adj.get(src)) {
                min=Math.min(min,dest[1]);
            if ( !visited[dest[0]]) {
               min=Math.min( min,dfsMinScore(visited, adj, dest[0]));
            }
        }
        return min;
    }
}
