import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizetheNumberofTargetNodesAfterConnectingTreesII {
    public static void main(String[] args) {
        int[] res = maxTargetNodes(new int[][] { {} }, new int[][] { {} });
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = build(edges1, color1,n);
        int[] count2 = build(edges2, color2,m);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return res;
    }

    private static int[] build(int[][] edges, int[] color,int n) {
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int res = dfs(0, -1, 0, children, color);
        return new int[] { res, n - res };
    }

    private static int dfs(int node,int parent, int depth, List<List<Integer>> children, int[] color ) {
        int res = 1 - (depth % 2);
        color[node] = depth % 2;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, depth + 1, children, color);
        }
        return res;
    }
    public int[] maxTargetNodes2(int[][] edges1, int[][] edges2) {
        final int[] t1 = target(edges1);
        final int plus = max(target(edges2));
        for (int i = 0; i < t1.length; i++) {
            t1[i] += plus;
        }
        return t1;
    }

    static final int max(int[] arr) {
        int r = 0;
        for (int a : arr) {
            r = Math.max(r, a);
        }
        return r;
    }

    static int[] target(int[][] edges) {
        final int n = edges.length + 1;
        final int[] degree = new int[n];
        final int[] parents = new int[n];
        final int[] balance = new int[n];
        Arrays.fill(balance, 1);
        final int[] q = new int[n];
        for (int[] e : edges) {
            final int start = e[0];
            final int end = e[1];
            degree[start]++;
            degree[end]++;
            parents[start] ^= end;
            parents[end] ^= start;
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q[len++] = i;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            final int node = q[i];
            final int parent = parents[node];
            parents[parent] ^= node;
            balance[parent] -= balance[node];
            if (--degree[parent] == 1) {
                q[len++] = parent;
            }
        }
        final int root = q[n - 1];
        balance[root] = (n + balance[root]) / 2;
        for (int i = n - 2; i >= 0; i--) {
            final int node = q[i];
            balance[node] = n - balance[parents[node]];
        }
        return balance;
    }
}