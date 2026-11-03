package problemsolvingIII;

import java.util.*;

public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {
    static void main() {
        System.out.println(shortestPath(3,new int[][]{{}},"aa",2));
    }
    public static int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        int[][] dist = new int[n][k+1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0,0,labels.charAt(0)-'a',1});// curr, weight,prev,cont
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cost = node[0];
            int src = node[1];
            int ch = node[2];
            int cont=node[3];
            if(src==n-1){
                return cost;
            }
            for(int[] next : adj.get(src)) {
                int l=labels.charAt(next[0])-'a';
                int dest=next[0];
                int newCont=0;
                if(l==ch){
                    newCont=cont+1;
                }else{
                    newCont=1;
                }
                int newCost=cost+next[1];
                if (newCont <= k && newCost < dist[dest][newCont]) {
                    dist[dest][newCont] = newCost;
                    q.add(new int[]{newCost, dest, l, newCont});
                }
            }
        }
        return -1;
    }
}
