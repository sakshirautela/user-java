import java.util.*;
public class ValidArrangementofPairs {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> inOutDegree = new HashMap<>();
        
        // Build graph and count in/out degrees
        for (int[] pair : pairs) {
            adjacencyList.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            inOutDegree.merge(pair[0], 1, Integer::sum);  // out-degree
            inOutDegree.merge(pair[1], -1, Integer::sum);  // in-degree
        }
        
        // Find starting node
        int startNode = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : inOutDegree.entrySet()) {
            if (entry.getValue() == 1) {
                startNode = entry.getKey();
                break;
            }
        }
        
        List<Integer> path = new ArrayList<>();
        Deque<Integer> nodeStack = new ArrayDeque<>();
        nodeStack.push(startNode);
        
        while (!nodeStack.isEmpty()) {
            List<Integer> neighbors = adjacencyList.getOrDefault(nodeStack.peek(), new ArrayList<>());
            if (neighbors.isEmpty()) {
                path.add(nodeStack.pop());
            } else {
                int nextNode = neighbors.get(neighbors.size() - 1);
                nodeStack.push(nextNode);
                neighbors.remove(neighbors.size() - 1);
            }
        }
        
        int pathSize = path.size();
        int[][] arrangement = new int[pathSize - 1][2];
        
        for (int i = pathSize - 1; i > 0; --i) {
            arrangement[pathSize - 1 - i] = new int[]{path.get(i), path.get(i-1)};
        }
        
        return arrangement;
    }
    public int[][] validArrangement2(int[][] pairs) {
        int n = pairs.length;
        
        int[][] ans = new int[n][2];
        for (int[] a : ans) {
            a[0] = -1;
            a[1] = -1;
        }
        
        Map<Integer, Integer> outdegree = new HashMap<>();
        Map<Integer, Deque<Integer>> out = new HashMap<>();
        
        for (int[] pair : pairs) {
            outdegree.put(pair[0], outdegree.getOrDefault(pair[0], 0) + 1);
            outdegree.put(pair[1], outdegree.getOrDefault(pair[1], 0) - 1);
            
            out.computeIfAbsent(pair[0], k -> new ArrayDeque<>());
            out.computeIfAbsent(pair[1], k -> new ArrayDeque<>());
            
            out.get(pair[0]).addLast(pair[1]);
        }
        
        for (Map.Entry<Integer, Integer> entry : outdegree.entrySet()) {
            if (entry.getValue() == 1) ans[0][0] = entry.getKey();
            if (entry.getValue() == -1) ans[n - 1][1] = entry.getKey();
        }
        
        if (ans[0][0] == -1) {
            ans[0][0] = pairs[0][0];
            ans[n - 1][1] = pairs[0][0];
        }
        
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int from = ans[i][0];
            
            Deque<Integer> toList = out.get(from);
            
            if (toList.size() == 0) {
                ans[j][0] = ans[--i][0];
                ans[--j][1] = ans[j + 1][0];
            } else {
                ans[i++][1] = toList.removeLast();
                ans[i][0] = ans[i - 1][1];
            }
        }
        
        return ans;
    }
    public static void main(String args[]){

    }
}