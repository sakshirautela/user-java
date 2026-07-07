package problemsolvingIII;

import java.util.*;

public class CreateBinaryTreeFromDescriptions {
    static void main() {
        System.out.println("Binary Tree from Descriptions");
    }

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, List<int[]>> set = new HashMap<>();
        HashSet<Integer> child = new HashSet<>();
        HashSet<Integer> par = new HashSet<>();
        int parent=-1;
        for (int[] description : descriptions) {
            int p = description[0];
            int c = description[1];
            int isLeft = description[2];
            par.add(p);
            child.add(c);
            set.putIfAbsent(p,new ArrayList<>());
            set.get(p).add(new int[]{c,isLeft});
        }
        for(int key : par){
            if(!child.contains(key)){
                parent=key;
            }
        }
        TreeNode root = new TreeNode(parent,null,null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!set.isEmpty()){
            List<int[]> list =set.get(queue.peek().val);
            TreeNode node = queue.poll();
            for(int[] l : list){
                if(l[1]==1){
                    node.left = new TreeNode(l[0],null,null);
                    queue.add(node.left);
                }else{
                    node.right = new TreeNode(l[0],null,null);
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

}
