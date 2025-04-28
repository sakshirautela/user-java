package com.learn.java.problemsolving;

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
public class RecoveraTreeFromPreorderTraversal {
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
        TreeNode node = recoverFromPreorder("");
        inOrder(node);
    }

    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    static int index = 0;

    public static TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return helper(traversal, 0);
    }

    private static TreeNode helper(String traversal, int depth) {
        if (index >= traversal.length())
            return null;
        int dashCount = 0;
        while ((index + dashCount) < traversal.length() &&
                traversal.charAt(index + dashCount) == '-') {
            dashCount++;
        }
        if (dashCount != depth)
            return null;

        index += dashCount;
        int value = 0;
        while (index < traversal.length() &&
                Character.isDigit(traversal.charAt(index))) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }

        TreeNode node = new TreeNode(value);

        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);

        return node;
    }
}