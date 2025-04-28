package com.learn.java.problemsolving;

public class MaximumProductofSplittedBinaryTree {
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
    int mod = 1000000007;
    long max = 0;
    long total;
    public int maxProduct(TreeNode root) {
        this.total = dfs(root);
        traverse(root);
        return (int)(max%mod);
    }
    
    private int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        return root.val += dfs(root.left) + dfs(root.right);
    }
    
    private void traverse(TreeNode root)
    {
        if(root==null)
            return;
        max = Math.max(root.val*(total-root.val),max);
        traverse(root.left);
        traverse(root.right);
    }
}