public class BinarySearchTreeGFG {
    static class Node {
        int data;
        Node left, right;
        
        public Node(int val) {
            this.data = val;
            this.left = this.right = null;
        }
        
        public Node() {
            this.left = this.right = null;
        }
    }
    
    public static void main(String[] args) {
        Node root = null;  
        int[] values = {97, 46, 37, 12, 3, 7, 31, 2, 4}; 
        
        root = createBinaryTree(values);
        
        System.out.println("In-order traversal of BST:");
        printInOrder(root);
        System.out.println("In-order traversal of BST:");
        printPreOrder(root);
        System.out.println("In-order traversal of BST:");
        printPostOrder(root);
    }
    
    private static Node createBinaryTree(int[] values) {
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        return root;
    }
    
    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }
    
    private static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }
    private static void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printInOrder(node.left);
            printInOrder(node.right);
        }
    }
    private static void printPostOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            printInOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    boolean isHeap(Node tree) {
        // code here
        int nodeCount=count(tree);
        return isHeapUtil(tree)&& isCompletetree(tree, 0, nodeCount);
    }

    private boolean isHeapUtil(Node root) {
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.left==null && root.right!=null){
            return false;
        }
        if(root.right==null){
            return (root.data>=root.left.data);
        }else{
            if(root.data>=root.left.data && root.data>=root.right.data){
                return isHeapUtil(root.left)&& isHeapUtil(root.right);
            }else{
                return false;
            }
        }
    }

    private int count(Node tree) {
        if(tree==null){
            return 0;
        }
        return 1+(count(tree.left)+count(tree.right));
    }

    private boolean isCompletetree(Node tree, int index,int nodes) {
        if(tree==null){
            return true;
        }
        if(index>=nodes){
            return false;
        }
        return (isCompletetree(tree.left, 2*index+1, nodes) && isCompletetree(tree.right, 2*index+2, nodes));
    }
    public static Node deleteNode(Node root, int X) {
        // code here.
        if(root.data==X){

        }
    }
}