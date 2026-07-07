package problemsolvingIII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostofBuyingCandiesWithDiscount {
    static void main() {
        System.out.println(minimumCost(new int[]{1, 2, 3, 4}));
    }

    public static int minimumCostFASDDDT(int[] costs) {
        int[] candies = new int[101];
        for (int c : costs) candies[c]++;
        int bought = 0;
        int cost = 0;
        for (int i = 100; i > 0; i--) {
            if (candies[i] > 2 - bought) {
                candies[i] -= (3 - bought);
                cost += (2 - bought) * i;
                cost += 2 * i * (candies[i] / 3);
                bought = candies[i] % 3;
                cost += i * bought;
            } else {
                bought += candies[i];
                cost += i * candies[i];
            }
        }
        return cost;
    }

    public int minimumCostFast(int[] cost) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : cost) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = 0;
            if (!pq.isEmpty()) {
                b = pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
            }
            res += (a + b);
        }
        return res;
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - i - 1) % 3 != 2) {
                res += cost[i];
            }
        }
        return res;
    }
}
