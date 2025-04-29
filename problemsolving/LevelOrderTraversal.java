import java.util.*;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LevelOrderTraversal {
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> levels = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal=Integer.MIN_VALUE;
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(maxVal<node.val){
                    maxVal = node.val;
                }
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(maxVal);
            System.out.println();
            level++;
        }
        System.out.println(levels);
    }

    public static void main(String[] args) {
        // Create the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Perform level-order traversal and print each level separately
        printLevelOrder(root);
    }
}
