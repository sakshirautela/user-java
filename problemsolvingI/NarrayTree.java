
import java.util.ArrayList;
import java.util.List;

public class NarrayTree{
    static class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> res=new ArrayList<Integer>();
        postorderHelper(root,res);
        return res;
    }

    private void postorderHelper(Node root, List<Integer> res) {
        if(root==null){
            return ;
        }
        for(Node i: root.children){
            postorderHelper(i,res);
        }
        res.add(root.val);
    }
    public void createtree(Node n,List<Node> list,int val){
        if(n==null){
            n=new Node(val,list);
        }
    }

    public static void main(String args[]){

    }
}
