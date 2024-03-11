import java.util.ArrayList;
import java.util.Stack;

public class CourseScheduleII {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int n, int arr[][]) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int src = arr[i][1];
            int dest = arr[i][0];
            graph[src].add(new Edge(src, dest));
        }
    }
    
    // cycle detection for directrd graph
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtill(graph, visited, i, stack)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isCycleUtill(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;
        for (int index = 0; index < graph[curr].size(); index++) {
            Edge e = graph[curr].get(index);
            if (stack[e.dest] == true) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycleUtill(graph, visited, e.dest, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(int n, int src, int res[], ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i] ) {
                topSortUtil(graph, visited, i, st);
            }
        }
        int i = 0;
        while (!st.empty()) {
            res[i] = st.pop();
            i++;
        }
    }

    private static void topSortUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> st) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSortUtil(graph, visited, e.dest, st);
            }
        }
        st.push(curr);
    }
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph, numCourses, prerequisites);

        if (isCycle(graph)){
            return new int[0];
        }
        topSort(numCourses, 0, res, graph);
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 0 } ,{0,1}};
        int n = 2;
        findOrder(n, arr);
    }
}
