package com.learn.java.problemsolving;

import java.util.HashMap;

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
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    static class TreeNode {
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

    static HashMap<Integer, Integer> hm;
    static int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder,int preStart, int preEnd,int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int idx = hm.get(val);
        int leftSubtreeSize = idx - inStart;

        root.left = helper(preorder, inorder,preStart + 1, preStart + leftSubtreeSize,inStart, idx - 1);

        root.right = helper(preorder, inorder,preStart + leftSubtreeSize + 1, preEnd,idx + 1, inEnd);

        return root;
    }
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
/*
class Solution {
    int i = 0;
    int j = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return build(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder, int[] inorder, int stop){
        if(i >= preorder.length) return null;
        if(stop == inorder[j]) {
            j++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[i]);
        i++;
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
}*/