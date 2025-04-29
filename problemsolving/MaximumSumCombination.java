
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumSumCombination {
    public static void main(String[] args) {
        System.out.println(maxCombinations(4,3, new int[] { 1, 4, 2, 3 }, new int[] { 2, 5, 1, 6}));
    }

    static List<Integer> maxCombinations(int n, int k, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(q[0], p[0]));
        Set<String> vis = new HashSet<>();
        pq.offer(new int[]{A[n - 1] + B[n-1], n - 1, n - 1});
        vis.add((n - 1) + "," + (n - 1));

        List<Integer> ans = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            ans.add(top[0]);
            
            int x = top[1], y = top[2];
            if (x - 1 >= 0 && !vis.contains((x - 1) + "," + y)) {
                pq.offer(new int[]{A[x - 1] + B[y], x - 1, y});
                vis.add((x - 1) + "," + y);
            }
            if (y - 1 >= 0 && !vis.contains(x + "," + (y - 1))) {
                pq.offer(new int[]{A[x] + B[y - 1], x, y - 1});
                vis.add(x + "," + (y - 1));
            }

            k--;
        }
        return ans;
    }
}
