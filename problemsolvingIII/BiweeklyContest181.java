package problemsolvingIII;

import java.util.ArrayList;

public class BiweeklyContest181 {
    static void main() {
        System.out.println(evenSumSubgraphs(new int[]{1}, new int[][]{}));
    }

    public static boolean validDigit(int n, int x) {
        boolean res = false;
        while (n >= 10) {
            if (n % 10 == x) {
                res = true;
            }
            n /= 10;
        }
        return (res && n != x);
    }

    public static int compareBitonicSums(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                peak = i - 1;
                break;
            }
            peak = i;
        }

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < peak; i++) {
            sum1 += nums[i];
        }
        for (int i = peak + 1; i < n; i++) {
            sum2 += nums[i];
        }

        if (sum1 == sum2) return -1;
        return sum1 > sum2 ? 0 : 1;
    }


    public static int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i,visited,graph,nums);
            }
        }
        return count;
    }

    static int count;
    private static int dfs(int src, boolean[] parent, ArrayList<ArrayList<Integer>> graph, int[] nums) {
        int sum = nums[src];
        if(sum%2==0){
            count++;
        }
        for (int dest : graph.get(src)) {
            if (!parent[dest]) {
                int childSum = dfs(dest, parent, graph, nums);
                sum += childSum;
            }
        }
        if (sum % 2 == 0) count++;
        return sum;
    }
}