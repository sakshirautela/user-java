import java.util.ArrayList;

public class TotalSumofInteractionCostinTreeGroups {
    public static void main(String[] args) {
        System.out.println(interactionCosts(4, new int[][]{}, new int[]{}));
    }

    public static long interactionCosts(int n, int[][] edges, int[] group) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] countOfGroups = new int[21];
        int[][] countOfSubGroups = new int[n][21];
        for (int i : group) {
            countOfGroups[i]++;
        }
        return dfs(graph, -1, 0, countOfGroups, countOfSubGroups, group);
    }

    private static long dfs(ArrayList<ArrayList<Integer>> graph, int par, int src, int[] countOfGroups, int[][] countOfSubGroups, int[] group) {
        long res = 0;
        countOfSubGroups[src][group[src]] = 1;
        for (int dest : graph.get(src)) {
            if ((par == dest)) {
                continue;
            }
            res += dfs(graph, src, dest, countOfGroups, countOfSubGroups, group);
            for (int i = 0; i < 21; i++) {
                if (countOfGroups[i] < 2) {
                    continue;
                }
                long sub = countOfSubGroups[dest][i];
                long outside = countOfGroups[i] - sub;
                res += sub * outside;
                countOfSubGroups[src][i] += countOfSubGroups[dest][i];
            }
        }
        return res;
    }
}