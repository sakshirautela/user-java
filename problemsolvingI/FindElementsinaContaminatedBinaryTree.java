
import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class FindElementsinaContaminatedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    HashSet<Integer> hs = new HashSet<>();

    public FindElementsinaContaminatedBinaryTree(TreeNode root) {
        FindElementsinaContaminatedBinaryTreeUtil(root, 0);
    }

    private void FindElementsinaContaminatedBinaryTreeUtil(TreeNode root, int i) {
        if(root==null){
            return ;
        }
        hs.add(i);
        FindElementsinaContaminatedBinaryTreeUtil(root.left,2*i+1);
        FindElementsinaContaminatedBinaryTreeUtil(root.right,2*i+2);
    }

    public boolean find(int target) {
        return hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
