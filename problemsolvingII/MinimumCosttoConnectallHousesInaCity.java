import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCosttoConnectallHousesInaCity {
    static void main() {
        System.out.println(minCost(new int[][]{{0, 7}, {0, 9}, {20, 7}, {30, 7}, {40, 70}}));
    }

    public static int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // cost+houseindex
        pq.offer(new int[]{0, 0});
        boolean[] visited = new boolean[n];
        int result = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int idx = cur[1];
            if (!visited[idx]) {
                visited[idx] = true;
                result += cost;
                for (int i = 0; i < n; i++) {
                    int dist = Math.abs(houses[idx][0] - houses[i][0]) + Math.abs(houses[idx][1] - houses[i][1]);
                    pq.offer(new int[]{dist, i});
                }
            }
        }
        return result;
    }
}
