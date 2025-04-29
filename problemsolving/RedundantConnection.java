
import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    public static void main(String[] args) {
        int[] res = findRedundantConnection(new int[][] { {} });
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    // Performs DFS and returns true if there's a path between src and target.
    private boolean isConnected(
            int src,
            int target,
            boolean[] visited,
            List<Integer>[] adjList) {
        visited[src] = true;

        if (src == target) {
            return true;
        }

        boolean isFound = false;
        for (int adj : adjList[src]) {
            if (!visited[adj]) {
                isFound = isFound || isConnected(adj, target, visited, adjList);
            }
        }

        return isFound;
    }

    public int[] findRedundantConnection1(int[][] edges) {
        int N = edges.length;

        @SuppressWarnings("unchecked")
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            boolean[] visited = new boolean[N];

            // If DFS returns true, we will return the edge.
            if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
                return new int[] { edge[0], edge[1] };
            }

            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        return new int[] {};
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int res[] = new int[2];
        int n = edges.length;
        boolean[] visited = new boolean[n];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u - 1].add(v);
            graph[v - 1].add(u);
        }
        findRedundantConnectionUtil(graph, res, 1, 0, visited);
        return res;
    }

    private static void findRedundantConnectionUtil(ArrayList<Integer>[] graph, int[] res, int curr, int par,
            boolean[] visited) {
        visited[curr - 1] = true;
        for (int dest : graph[curr]) {
            if (!visited[dest - 1] && dest != par) {
                findRedundantConnectionUtil(graph, res, dest, curr, visited);
            } else {
                res[0] = curr;
                res[1] = dest;
            }
        }
    }

    class DSU {

        @SuppressWarnings("unused")
        private int N;
        private int[] size;
        private int[] representative;

        // Initialize DSU class, size of each component will be one and each node
        // will be representative of it's own.
        public DSU(int N) {
            this.N = N;
            size = new int[N];
            representative = new int[N];

            for (int node = 0; node < N; node++) {
                size[node] = 1;
                representative[node] = node;
            }
        }

        // Returns the ultimate representative of the node.
        public int find(int node) {
            if (representative[node] == node) {
                return node;
            }

            return representative[node] = find(representative[node]);
        }

        // Returns true if node nodeOne and nodeTwo belong to different component and
        // update the
        // representatives accordingly, otherwise returns false.
        public boolean doUnion(int nodeOne, int nodeTwo) {
            nodeOne = find(nodeOne);
            nodeTwo = find(nodeTwo);

            if (nodeOne == nodeTwo) {
                return false;
            } else {
                if (size[nodeOne] > size[nodeTwo]) {
                    representative[nodeTwo] = nodeOne;
                    size[nodeOne] += size[nodeTwo];
                } else {
                    representative[nodeOne] = nodeTwo;
                    size[nodeTwo] += size[nodeOne];
                }
                return true;
            }
        }
    }

    public int[] findRedundantConnection2(int[][] edges) {
        int N = edges.length;

        DSU dsu = new DSU(N);
        for (int[] edge : edges) {
            // If union returns false, we know the nodes are already connected
            // and hence we can return this edge.
            if (!dsu.doUnion(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[] {}; // This line should theoretically never be reached
    }

    public int[] findRedundantConnection3(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int root_u = u;
            while (parent[root_u] != root_u) {
                parent[root_u] = parent[parent[root_u]];
                root_u = parent[root_u];
            }
            int root_v = v;
            while (parent[root_v] != root_v) {
                parent[root_v] = parent[parent[root_v]];
                root_v = parent[root_v];
            }
            if (root_u == root_v) {
                return edges[i];
            }
            parent[root_u] = root_v;
        }

        return new int[] {};
    }

    public int[] findRedundantConnection4(int[][] edges) {

        int n = edges.length;
        int p[] = new int[n + 1];

        for (int i = 1; i < n + 1; i++)
            p[i] = i;

        int ans[] = { 0, 0 };

        for (int i = 0; i < n; i++) {

            int p1 = p[edges[i][0]];
            int p2 = p[edges[i][1]];

            while (p1 != p[p1])
                p1 = p[p1];

            while (p2 != p[p2])
                p2 = p[p2];

            if (p1 == p2) {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            } else {
                p[p2] = p1;
            }

        }

        return ans;

    }
}
