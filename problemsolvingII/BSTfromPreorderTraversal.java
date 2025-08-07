import java.util.Arrays;
import java.util.Stack;

public class BSTfromPreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        inorder(root);
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < n; i++) {
            TreeNode temp = null;
            while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                temp = stack.pop();
            }

            if (temp != null) {
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
        }
        return root;
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
        TreeNode insertNode(TreeNode node,int value)
        {
            if(node == null) return new TreeNode(value);
            if(node.val > value)
            {
                node.left = insertNode(node.left,value);
            }
            else{
                node.right = insertNode(node.right,value);
            }
            return node;
        }
        public TreeNode bstFromPreorder2(int[] preorder) {
            TreeNode node = new TreeNode(preorder[0]);
            for(int i = 1; i< preorder.length; i++)
            {
                TreeNode t = insertNode(node,preorder[i]);
            }
            return node;
        }
}
