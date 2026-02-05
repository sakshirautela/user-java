import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReachableNodesInSubdividedGraph {
    static void main() {
        System.out.println(reachableNodes(new int[][]{}, 4, 5));
    }

    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        boolean[] visited=new boolean[n];
        int result=0;
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            visited[curr[0]]=true;
            int balance=curr[1];
            for(int[] neighouber:graph.get(curr[0])){
                int cnt=balance+neighouber[1];
                int neigh=neighouber[0];
                if(maxMoves>cnt+balance){
                    pq.add(new int[]{neigh,Math.max(maxMoves-cnt-balance,0)});
                    result+=Math.max(cnt+balance,0);
                }
            }
        }
        return result;
    }
}
