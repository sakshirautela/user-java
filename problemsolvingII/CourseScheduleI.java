import java.util.ArrayList;

public class CourseScheduleI {
    static void main() {

    }

    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        int[] indegree = new int[n];
        int[] visited = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < n; i++) {
             if(dfs(i, graph, visited, indegree)){
                 return true;
             }
        }
        return false;
    }

    private boolean dfs(int i, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] indegree) {
        if (indegree[i] == 1) {
            return false;
        }
        if (visited[i] == 1) {
            return true;
        }
        visited[i] = 1;
        indegree[i] = 1;
        for (int dest : graph.get(i)) {
            if (!dfs(dest, graph, visited, indegree)) {
                return false;
            }
        }
        indegree[i] = 0;
        return true;
    }
}
