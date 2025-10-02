import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
       int[] arr={1,2,3,4,5,6,7};
       Node root=buildNode(arr,0);
       connect(root);
    }

    public static void inorder(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public static Node buildNode( int[] val, int idx) {
        if(idx>=val.length){
            return null;
        }
        Node root=new Node();
        root.val=val[idx];
        root.left=buildNode(val,idx*2+1);
        root.right=buildNode(val,idx*2+2);
        return root;
    }

    public static Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        root.next=null;
        q.add(root);
        q.add(null);
        List<Node> li=new ArrayList<>();
        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    li.add(null);
                    q.add(null);
                }
            } else {
                System.out.print(n.val+" ");
                if (n.left != null) {
                    q.add(n.left);
                    li.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                    li.add(n.right);
                }
            }
        }
        for (int i = 0; i <li.size()-1 ; i++) {
            li.get(i).next=li.get(i+1);
        }
        return root;
    }
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    public Node connect2(Node root) {
        if (root == null){
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

}