import java.util.*;
public class GratestCommonDivisionTraversal {
    public static class Node{
        int src;int dest;
        public Node(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void creatGraph(ArrayList<Node> graph,int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(gcd(nums[i],nums[j])>1){
                    graph.add(new Node(i,j));
                    graph.add(new Node(j,i));
                }
            }
        }
    }
    private static int gcd(int i, int j) {
        if(j==0){
            return i;
        }
        return gcd(j,i%j);
    }
    public static boolean canTraverseAllPairs(int[] nums) {
        ArrayList<Node> graph=new ArrayList<Node>();
        creatGraph(graph, nums);
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(graph.get(i).src+" "+graph.get(i).dest);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(canTraverseAllPairs(new int[]{2,3,6}));
    }
}
