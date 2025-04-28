import java.util.Queue;
import java.util.LinkedList;

public class HouseRobberIII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int money=0;
        if(root.left!=null){
            money+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            money+=rob(root.right.left)+rob(root.right.right);
        }
        return Math.max(money+root.val,rob(root.left)+rob(root.right));
    }
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rob(root.left);
        rob(root.right);
        int robThisNode = root.val;
        int dontRobThisNode = 0;
        if (root.left != null) {
            dontRobThisNode += root.left.val;
            if (root.left.left != null) {
                robThisNode += root.left.left.val;
            }
            if (root.left.right != null) {
                robThisNode += root.left.right.val;
            }
        }
        if (root.right != null) {
            dontRobThisNode += root.right.val;
            if (root.right.left != null) {
                robThisNode += root.right.left.val;
            }
            if (root.right.right != null) {
                robThisNode += root.right.right.val;
            }
        }
        root.val = Math.max(robThisNode, dontRobThisNode);
        return root.val;
    }
    

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public int rob3(TreeNode root) {
        int[] rs = helper(root);
        return Math.max(rs[0], rs[1]);
        
    }

    private int[] helper(TreeNode curr){
        if(curr == null) return new int[]{0, 0};

        int[] l = helper(curr.left);
        int[] r = helper(curr.right);

        int robbed = curr.val + l[1]+ r[1];
        int notRobbed = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

        return new int[]{robbed, notRobbed};

    }
}