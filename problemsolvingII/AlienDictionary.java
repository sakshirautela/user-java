import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlienDictionary {
    static class edge{
        char src;
        char dest;
        public edge(char src,char dest){
            this.src=src;
            this.dest=dest;
        }
    }
    

// User function Template for Java

    private static void topologicalSort(int v, boolean[] visited, Stack<Character> stack, List<List<Integer>> adj) {
        visited[v] = true;
        
        // Go through all the adjacent vertices
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adj);
            }
        }
        
        // Push the vertex to stack after visiting all its adjacent vertices
        stack.push((char) (v + 'a'));
    }
    public static String findOrder(String[] dict, int n, int k) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Building the graph
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            
            // Find the first differing character
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        // Stack to store the topological order
        Stack<Character> stack = new Stack<>();
        
        // Boolean array to keep track of visited vertices
        boolean[] visited = new boolean[k];
        
        // Perform topological sort for all vertices
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adj);
            }
        }
        
        // Construct the result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }

    public static void main(String args[]){
        System.out.println(findOrder(new String[]{"baa","abcd","abca","cab","cad"},5,4));
    }
}
