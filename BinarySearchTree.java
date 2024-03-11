class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BinarySearchTree {
    static Node root;
    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        BinarySearchTree.insert(root,34);
        bst.insert(root,24);  
        bst.insert(root,42);
        bst.insert(root,44);
    }  
    static Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        Node node=new Node(val);
        if(root.data>val){
            root.left=insert(root.left,val);
        }
        else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    static Node delete(Node root,int key){
        if(root==null ){
            return null;
        }
    }
}
