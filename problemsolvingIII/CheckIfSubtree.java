package problemsolvingIII;

public class CheckIfSubtree {
    static void main() {

    }
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        if(root2 == null ){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(isSubTreeFind(root1,root2)){
            return true;
        }
        return isSubTree(root1.left,root2)||isSubTree(root1.right,root2);
    }

    private boolean isSubTreeFind(Node root1, Node root2) {
        if(root2==null && root1==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return root2.data==root1.data && isSubTreeFind(root1.left,root2.left) && isSubTreeFind(root1.right,root2.right);
    }
}
