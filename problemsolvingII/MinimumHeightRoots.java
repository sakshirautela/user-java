import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class MinimumHeightRoots {
    static void main() {
        System.out.println(minHeightRoot(5, new int[][]{{0, 2}, {1, 2}, {2, 3}, {3, 4}}));
    }

    public static ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[V];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        int rem = V;
        while (rem > 2) {
            int size = q.size();
            rem -= size;
            while (size-- > 0) {
                int a = q.remove();
                for (int child : graph.get(a)) {
                    degree[child]--;
                    if (degree[child] == 1) {
                        q.add(child);
                    }
                }
            }
        }
        //System.out.println(q);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.remove());
        }
        return ans;
    }

    private static int dfs(int v, ArrayList<ArrayList<Integer>> graph, int src, TreeMap<
            Integer, ArrayList<Integer>> minHeight, boolean[] visited, int depth, int[] indegree) {
        if (visited[src]) {
            return depth;
        }
        visited[src] = true;
        indegree[src] = Math.max(indegree[src], depth);
        int max = 0;
        for (int next : graph.get(src)) {
            max = Math.max(max, dfs(v, graph, next, minHeight, visited, depth + 1, indegree));
        }
        return max;
    }

    public static ArrayList<Integer> minHeightRootTLE(int V, int[][] edges) {
        // Code here
        TreeMap<Integer, ArrayList<Integer>> minHeight = new TreeMap<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            int height = minHeightRootUtil(V, graph, i, minHeight, new boolean[V], 0);
            if (height < min) {
                min = height;
            }
            if (minHeight.containsKey(height)) {
                minHeight.get(height).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                minHeight.put(height, list);
            }
        }
        return minHeight.get(min);
    }

    private static int minHeightRootUtil(int v, ArrayList<ArrayList<Integer>> graph, int src, TreeMap<
            Integer, ArrayList<Integer>> minHeight, boolean[] visited, int depth) {
        if (visited[src]) {
            return depth;
        }
        visited[src] = true;
        int max = 0;
        for (int next : graph.get(src)) {
            max = Math.max(max, minHeightRootUtil(v, graph, next, minHeight, visited, depth + 1));
        }
        return max;
    }
}
