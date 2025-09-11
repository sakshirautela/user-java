import java.util.*;

public class JumpGameIX {
    public static void main(String[] args) {
        int[] nums = {5, 1, 4, 2, 3};
        nums = maxReachable(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static int[] maxReachable(int[] nums) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                graph.get(st.peek()).add(i); // don't lose edges
                st.pop();
            }
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                graph.get(st.peek()).add(i);
                st.pop();
            }
            st.push(i);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            dfs(i, nums, graph, dp);
        }

        return dp;
    }

    private static int dfs(int i, int[] nums, List<List<Integer>> graph, int[] dp) {
        if(i<0|| i==nums.length){
            return 0;
        }
        if (dp[i] != Integer.MIN_VALUE) return dp[i];

        int m = nums[i];
        for (int next : graph.get(i)) {
            m = Math.max(m, dfs(next, nums, graph, dp));
        }

        return dp[i] = m;
    }
}
