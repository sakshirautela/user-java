import java.util.ArrayList;
import java.util.HashSet;

public class CloneUndirectedGraphGFG {
    static class Node{
            int val;
            ArrayList<Node> neighbors;
            public Node(){
                val = 0;
                neighbors = new ArrayList<>();
            }
    
            public Node(int val){
                this.val = val;
                neighbors = new ArrayList<>();
            }
    
            public Node(int val, ArrayList<Node> neighbors){
                this.val = val;
                this.neighbors = neighbors;
            }
        }
    public static void main(String[] args) {
        
    }
    Node cloneGraph(Node node) {
        // code here
        HashSet<Integer> visited=new HashSet<>();
        return cloneGraphUtill(node,visited);
    }
    private Node cloneGraphUtill(Node node, HashSet<Integer> visited) {
        Node newNode=new Node(node.val);
        visited.add(node.val);
        for (Node n:node.neighbors) {
            if(!visited.contains(n.val)){
                newNode.neighbors.add(cloneGraphUtill(n, visited));
            }
        }
        return newNode;
    }
}
