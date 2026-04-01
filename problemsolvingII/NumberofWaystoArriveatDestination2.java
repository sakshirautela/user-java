import java.util.*;

public class NumberofWaystoArriveatDestination2 {
    static void main() {
        System.out.println(countPaths(4, new int[][]{{0, 1, 2}, {1, 2, 3}, {0, 3, 5}, {1, 3, 3}, {2, 3, 4}}));
    }

    public static int countPathsDFS(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        dfstime(0, 0, graph, visited, V);
        int count = 0;
        return count;
    }

    private static int dfstime(int dist, int src, ArrayList<ArrayList<int[]>> graph, boolean[] visited, int v) {
        if (src == v - 1) {
            return dist;
        }
        int a = 0;
        visited[src] = true;
        for (int[] dest : graph.get(src)) {
            a = dfstime(dist + dest[1], dest[0], graph, visited, v);
        }
        return a;
    }

    public static int countPaths(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        int[] dist= new int[V];
        int[] ways= new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
                graph.get(e[1]).add(new int[]{e[0], e[2]});

        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{0, 0});
        dist[0] = 0;
        ways[0] = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dest : graph.get(node[0])) {
                if(node[1] + dest[1]<dist[dest[0]]) {
                    dist[dest[0]] = node[1] + dest[1];
                    ways[dest[0]] = ways[node[0]];
                    queue.add(new int[]{dest[0], node[1]+dest[1]});
                }else if(node[1] + dest[1]==dist[dest[0]]) {
                    ways[dest[0]]+=ways[node[0]];
                }
            }
        }
        return ways[V-1];
    }
}
