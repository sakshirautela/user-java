import java.util.HashMap;

public class CloneBinaryTreeGFG {
    static class Tree{
        int data;
        Tree left,right,random;
        Tree(int d){
            data=d;
            left=null;
            right=null;
            random=null;
        }
    }
    public static void main(String[] args) {
        System.out.println();
    }
    HashMap<Tree,Tree> contains=new HashMap<>();
    public Tree cloneTree(Tree root) {
        // add code here.
        if(root==null){
            return null;
        }
        if(contains.containsKey(root)){
            return contains.get(root);
        }
        Tree newTree=new Tree(root.data);
        contains.put(root, newTree);
        newTree.left=cloneTree(root.left);
        newTree.right=cloneTree(root.right);
        newTree.random=cloneTree(root.random);
        return newTree;
    }
}