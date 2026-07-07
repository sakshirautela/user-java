package problemsolvingIII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationstoreachEnd {
    static void main() {
        System.out.println(minSteps(new int[]{2, 5, 7}, 3, 30));
    }

    public static int minSteps(int[] arr, int start, int end) {
        // code here
        int MOD = 1000;

        start %= MOD;
        end %= MOD;

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[MOD];

        Arrays.fill(visited, -1);

        q.add(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == end) {
                return visited[curr];
            }

            for (int i : arr) {
                int dest = (curr * i) % MOD;

                if (visited[dest] == -1) {
                    visited[dest] = visited[curr] + 1;
                    q.add(dest);
                }
            }
        }

        return -1;
    }
}