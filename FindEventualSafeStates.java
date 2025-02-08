import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][] { {} }));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                li.add(i);
            }
        }
        return li;
    }
    List<Integer> safeNodes;
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        // int n = graph.length;
        // List<List<Integer>> reverseAdj = new ArrayList<>();
        // List<Integer> safeNodes = new ArrayList<>();
        // int[] inDegree = new int[n];

        // for(int i = 0; i < n; i++){
        //     reverseAdj.add(new ArrayList<>());
        // }

        // for(int i = 0; i < n; i++){
        //     for(int neighborNode: graph[i]){
        //         reverseAdj.get(neighborNode).add(i);
        //         inDegree[i]++;
        //     }
        // }

        // Queue<Integer> queue = new LinkedList<Integer>();
        // for(int i = 0; i < n; i++){
        //     if(inDegree[i] == 0){
        //         queue.offer(i);
        //     }
        // }

        // while(!queue.isEmpty()){
        //     int safeNode = queue.poll();
        //     safeNodes.add(safeNode);

        //     for(int neighbor : reverseAdj.get(safeNode)){
        //         inDegree[neighbor]--;
        //         if(inDegree[neighbor] == 0){
        //             queue.offer(neighbor);
        //         }
        //     }
        // }
        // Collections.sort(safeNodes);
        // return safeNodes;
        return new AbstractList<Integer>(){
            @Override
            public Integer get(int index){
                init();
                return safeNodes.get(index);
            }

            @Override
            public int size(){
                init();
                return safeNodes.size();
            }

            private void init(){
                if(safeNodes != null) return;

                int n = graph.length;
                List<List<Integer>> reverseAdj = new ArrayList<>();
                safeNodes = new ArrayList<>();
                int[] inDegree = new int[n];

                for(int i = 0; i < n; i++){
                    reverseAdj.add(new ArrayList<>());
                }

                for(int i = 0; i < n; i++){
                    for(int neighborNode: graph[i]){
                        reverseAdj.get(neighborNode).add(i);
                        inDegree[i]++;
                    }
                }

                Queue<Integer> queue = new LinkedList<Integer>();
                for(int i = 0; i < n; i++){
                    if(inDegree[i] == 0){
                        queue.offer(i);
                    }
                }

                while(!queue.isEmpty()){
                    int safeNode = queue.poll();
                    safeNodes.add(safeNode);

                    for(int neighbor : reverseAdj.get(safeNode)){
                        inDegree[neighbor]--;
                        if(inDegree[neighbor] == 0){
                            queue.offer(neighbor);
                        }
                    }
                }
                Collections.sort(safeNodes);
            }
        };   
    }
}