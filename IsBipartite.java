import java.util.Arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class IsBipartite {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void graphCreation(ArrayList<Edge>[] graph, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                graph[i].add(new Edge(i, arr[i][j]));
            }
        }
    }

    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Edge>[] g = new ArrayList[graph.length];
        graphCreation(g, graph);
        for (int i = 0; i < g.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < g[curr].size(); j++) {
                        Edge e = g[curr].get(j);
                        if (color[e.dest] == -1) {
                            // fill color
                            color[e.dest] = color[curr] == 0 ? 1 : 0;
                            q.add(e.dest);
                        } else if (color[curr] == color[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite2(int[][] graph) {
        int[] checked = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (checked[i] == 0 && !checkGraph(graph, i, 1, checked))
                return false;
        return true;
    }

    public boolean checkGraph(int[][] graph, int index, int currChecked, int[] checked) {
        if (checked[index] != 0) {
            return checked[index] == currChecked;
        }
        checked[index] = currChecked;
        for (int next : graph[index]) {
            if (!checkGraph(graph, next, -currChecked, checked)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(arr));
    }
}