public class ConstructBinaryTreefromPreorderandPostorderTraversal {
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

    public static void main(String[] args) {

    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;
        return constructTree(0, numOfNodes - 1, 0, preorder, postorder);
    }

    private TreeNode constructTree(int preStart,int preEnd,int postStart,int[] preorder,int[] postorder) {
        if (preStart > preEnd)
            return null;

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int leftRoot = preorder[preStart + 1];
        int numOfNodesInLeft = 1;
        while (postorder[postStart + numOfNodesInLeft - 1] != leftRoot) {
            numOfNodesInLeft++;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = constructTree(preStart + 1,preStart + numOfNodesInLeft,postStart,preorder,postorder);
        root.right = constructTree(preStart + numOfNodesInLeft + 1,preEnd,postStart + numOfNodesInLeft,preorder,postorder);
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
    public TreeNode constructFromPrePost2(int[] preorder, int[] postorder) {
        // preoder   CLR
        // inorder   LCR
        // postorder LRC

        return helper(preorder, postorder, 0, preorder.length - 1, 0); 
    }

    private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart) {
        if(preStart > preEnd || postStart >= postorder.length || preStart >= preorder.length ) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);

        TreeNode root = new TreeNode(preorder[preStart]);
        int leftRoot = preorder[preStart + 1];
        int leftNodeCount = 1;
        while(leftRoot != postorder[postStart + leftNodeCount - 1]) leftNodeCount++;

        TreeNode leftNode = helper(preorder, postorder, preStart + 1, preStart + leftNodeCount, postStart);
        root.left = leftNode;
        TreeNode rightNode = helper(preorder, postorder, preStart + leftNodeCount + 1, preEnd, postStart + leftNodeCount);
        root.right = rightNode;
        return root;
    }
}