
import java.util.ArrayList;
import java.util.List;

public class CounttheNumberofCompleteComponents {
    public static void main(String[] args) {
        System.out.println(countCompleteComponents(5, new int[][] { {} }));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<Integer>());
        }
        int componets = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> nodes = new ArrayList<>();
                dfs(i, visited, al, nodes);

                int totalEdges = 0;
                for (int node : nodes) {
                    totalEdges += al.get(node).size();
                }

                int k = nodes.size();
                if (totalEdges / 2 == (k * (k - 1)) / 2) {
                    componets++;
                }
            }
        }
        return componets;
    }

    private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> al, List<Integer> nodes) {
        visited[i] = true;
        nodes.add(i);
        for (int dest : al.get(i)) {
            if (!visited[dest]) {
                dfs(dest, visited, al, nodes);
            }
        }
    }

    public int find(int node, int[] parent) {
        if (parent[node] == node)
            return node;
        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    public void merge(int x, int y, int[] parent, int[] size, int[] eno) {

        int parentX = find(x, parent);
        int parentY = find(y, parent);

        if (parentX == parentY) {
            eno[parentX] += 1;
            return;
        }

        if (size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
            eno[parentX] += eno[parentY] + 1;
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
            eno[parentY] += eno[parentX] + 1;
        }
    }

    public int countCompleteComponents2(int n, int[][] edges) {

        int[] parent = new int[n];
        int[] size = new int[n];
        int[] eno = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            eno[i] = 0;
        }

        for (int i = 0; i < edges.length; i++) {
            merge(edges[i][0], edges[i][1], parent, size, eno);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (parent[i] == i && (eno[i] == ((size[i] * (size[i] - 1)) / 2))) {
                ans++;
            }

        }

        return ans;
    }
}
