package problemsolvingIII;

import java.util.ArrayList;
import java.util.Arrays;

public class MotherVertex {
    static void main() {
        System.out.println(findMotherVertex(4,new int[][]{{}}));
    }
        public static int findMotherVertex(int V, int[][] edges) {
            // code here
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++) {
                adj.add(new ArrayList<>());
            }
            for(int[] edge:edges) {
                adj.get(edge[0]).add(edge[1]);
            }
            int result=-1;
            boolean[] visited = new boolean[V];
            for(int i=0;i<V;i++) {
                if(!visited[i]) {
                    findMotherVertexDfs(i,visited,adj);
                    result=i;
                }
            }
            Arrays.fill(visited, false);
            findMotherVertexDfs(result, visited, adj);
            for(int i=0;i<V;i++) {
                if(!visited[i]) {
                    return -1;
                }
            }
            return result;
        }

    private static void findMotherVertexDfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        for(int j:adj.get(i)) {
            if(!visited[j]) {
                findMotherVertexDfs(j,visited,adj);
            }
        }
    }
}
