package problemsolvingIII;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class NetworkRecoveryPathways {
    static void main() {
        System.out.println(findMaxPathScore(new int[][]{{0,1,5},{1,3,10},{0,2,3},{2,3,4}}, new boolean[]{true,true,true,true}, 10));
    }

    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int n = online.length;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        boolean[] visited = new boolean[n];
        pq.add(new int[]{0, 0, Integer.MAX_VALUE});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            if (cur[0] == n-1) {
                q.add(cur[2]);
            }
            for (int[] dest : adj.get(cur[0])) {
                if (cur[1] + dest[1] <= k && online[dest[0]] && !visited[dest[0]]) {
                    pq.add(new int[]{dest[0],cur[1]+dest[1],Math.min(cur[2],dest[1])});
                }
            }
        }
        System.out.println(q);
        if(q.isEmpty()){
            return -1;
        }
        if(q.peek()==Integer.MAX_VALUE){
            return -1;
        }
        return q.peek();
    }
}
