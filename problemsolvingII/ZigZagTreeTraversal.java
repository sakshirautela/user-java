import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {
static class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}

        ArrayList<Integer> zigZagTraversal(Node root) {
            // code here
            ArrayList<ArrayList<Integer>> al=new ArrayList<>();
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            al.add(new ArrayList<>());
            //al.getFirst().add(root.data);
            boolean isBeg=false;
            while (!q.isEmpty()){
                Node curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                        isBeg=!isBeg;
                        al.add(new ArrayList<>());
                    }
                }else{
                    if(isBeg){
                        al.getLast().addFirst(curr.data);
                    }else{
                        al.getLast().addLast(curr.data);
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
            ArrayList<Integer>res=new ArrayList<>();
            for(ArrayList<Integer> i:al){
                res.addAll(i);
            }
            return res;

    }
    public static void main(String[] args) {

    }

    public static class MaximumLengthofPairChain {
        static void main() {
            System.out.println(findLongestChain(new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}}));
        }

        public static int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
            int result = 0;
            int n = pairs.length;
            for (int i = 0; i < n; i++) {
                int prev = -1001;
                int chain = 0;
                for (int j = i; j < n; j++) {
                    if (pairs[j][0] > prev) {
                        result++;
                        prev = pairs[j][1];
                    }
                    result = Math.max(result, chain);
                }
            }
            return result;
        }
    }
}
