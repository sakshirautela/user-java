import java.util.ArrayList;
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
}
