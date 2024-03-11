import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree {

    // public Node GetNode(int i) {

    // return new Node(i);
    // }

    // static Node root;

    public static TreeNode insertion(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        if (root.val > val) {
            root.left = insertion(root.left, val);
        } else {
            root.right = insertion(root.right, val);
        }
        return root;

    }

    // // BFS-inorder ,postorder,preorder
    // public void preOrder(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    // System.out.println(root.val);
    // preOrder(root.left);
    // preOrder(root.right);

    // }

    // public void inOrder(TreeNode root) {
    // if (root == null) {
    // return;
    // }

    // inOrder(root.left);
    // System.out.println(root.val);
    // inOrder(root.right);

    // }

    // public List<Integer> inorderTraversal(TreeNode root) {
    // List<Integer> res = new ArrayList<>();
    // if (root == null) {
    // return res;
    // }
    // while (root.left != null) {
    // res.add(root.val);
    // root = root.left;
    // }
    // res.add(root.val);
    // while (root.right != null) {
    // res.add(root.val);
    // root = root.right;

    // }
    // return res;
    // }

    // public void postOrder(TreeNode root) {
    // if (root == null) {
    // return;
    // }

    // postOrder(root.left);
    // postOrder(root.right);
    // System.out.println(root.val);

    // }

    // public void BFS(TreeNode root) {
    // if(root==null){
    // return;
    // }
    // Queue<TreeNode> q = new LinkedList();
    // q.add(root);
    // q.add(null);
    // while (!q.isEmpty()) {
    // TreeNode curr=q.remove();
    // if(curr==null){
    // System.out.println();
    // if(q.isEmpty()){
    // break;
    // }
    // else{
    // q.add(null);
    // }
    // }
    // else{
    // System.out.print(curr.val+" ");
    // if(curr.left!=null){
    // q.add(curr.left);
    // }
    // if(curr.right!=null){
    // q.add(curr.right);
    // }
    // }
    // }
    // }

    // public int height(TreeNode root) {
    // int count1 = 0;
    // int count2 = 0;
    // while (root.left != null) {
    // root = root.left;
    // count1++;
    // }
    // while (root.right != null) {
    // root = root.right;
    // count2++;
    // }
    // if (count1 >= count2) {
    // return count1 + 1;
    // }
    // return count2 + 1;
    // }

    // public static int heightRecursion(TreeNode root) {
    // if(root==null){
    // return 0;
    // }
    // int count1 = heightRecursion(root.left);
    // int count2 = heightRecursion(root.right);

    // if (count1 >= count2) {
    // return count1 + 1;
    // }
    // return count2 + 1;
    // }

    // public int NodeCount(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // int count1 = NodeCount(root.left);
    // int count2 = NodeCount(root.right);

    // return count1+count2 + 1;
    // }

    // public int countNodes(TreeNode root) {
    // int h = 0;
    // TreeNode temp = root;
    // while (root.left != null) {
    // root = root.left;
    // h++;
    // }
    // while (temp.right != null) {
    // temp = temp.right;
    // h++;
    // }
    // return h + 1;
    // // /**
    // // * Definition for a binary tree node.
    // // * public class TreeNode {
    // // * int val;
    // // * TreeNode left;
    // // * TreeNode right;
    // // * TreeNode() {}
    // // * TreeNode(int val) { this.val = val; }
    // // * TreeNode(int val, TreeNode left, TreeNode right) {
    // // * this.val = val;
    // // * this.left = left;
    // // * this.right = right;
    // // * }
    // // * }
    // // */
    // // class Solution {
    // // public int countNodes(TreeNode root) {
    // // return root == null ? 0 : countNodes(root.left) + countNodes(root.right) +
    // 1;
    // // }
    // // }
    // }

    // public static int sumNode(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // int sum1 = sumNode(root.left);
    // int sum2 = sumNode(root.right);

    // return sum1 + sum2 + root.val;
    // }
    // public static int daimeter(TreeNode root){
    // if(root==null){
    // return 0;
    // }
    // int lh=heightRecursion(root.left);
    // int rh = heightRecursion(root.right);
    // int ld=daimeter(root.left);
    // int rd = daimeter(root.right);
    // int self=lh+rh+1;
    // return Math.max(self,Math.max(rd, ld));
    // }

    // public static class Info{
    // int d;
    // int h;
    // Info(int d,int h){
    // this.d=d;
    // this.h=h;
    // }
    // }
    // public static Info diameter2(TreeNode root){
    // if(root==null){
    // return new Info(0, 0);
    // }
    // Info linfo=diameter2(root.left);
    // Info rinfo = diameter2(root.right);
    // int dia=Math.max(Math.max(linfo.d, rinfo.d), linfo.h+rinfo.h+1);
    // int hei=Math.max(rinfo.h,linfo.h)+1;
    // return new Info(dia,hei);
    // }
    // public static boolean isSubtree(TreeNode root,TreeNode subRoot){
    // if(root==null){
    // return false;
    // }
    // if(root.val==subRoot.val){
    // if(isIdentical(root,subRoot)){
    // return true;
    // }
    // }
    // return (isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot));
    // }

    // private static boolean isIdentical(TreeNode root, TreeNode subRoot) {
    // if(root==null && subRoot==null){
    // return true;
    // }
    // if (root == null || subRoot == null || root.val != subRoot.val) {
    // return false;
    // }
    // if(!isIdentical(root.left, subRoot.left)){
    // return false;
    // }
    // if (!isIdentical(root.right, subRoot.right)) {
    // return false;
    // }
    // return true;
    // }
    static class Info {
        TreeNode node;
        public Object left;
        int hd;

        Info(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(TreeNode root) {
        // level order traversal
        Queue<Info> q = new LinkedList<>();
        int min = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        q.add(new Info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node.val);
                }
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    min = Math.min(min, curr.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i));
        }
    }

    public static void kthLevel(TreeNode root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.println(root.val);
            return;
        }
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    public static TreeNode lowestCommonAncester2(TreeNode root, int n1, int n2) {
        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }
        TreeNode leftN = lowestCommonAncester2(root.left, n1, n2);
        TreeNode rightN = lowestCommonAncester2(root.right, n1, n2);
        if (leftN != null || rightN == null) {
            return leftN;
        }
        if (rightN != null || leftN == null) {
            return rightN;
        }
        return root;
    }

    public static int lowestCommonAncester(TreeNode root, int n1, int n2) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> path1 = new ArrayList<>();
        getPath(root, n1, path1);
        ArrayList<TreeNode> path2 = new ArrayList<>();
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() || i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        return path1.get(i).val;
    }

    private static boolean getPath(TreeNode root, int n, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == n) {
            return true;
        }
        boolean lefNode = getPath(root.left, n, path);
        boolean rigNode = getPath(root.left, n, path);
        if (lefNode || rigNode) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static int minDistanceTwoNodes(TreeNode root, int n1, int n2) {
        if (root == null) {
            return 0;
        }
        int dist1 = getlcd(root, n1);
        int dist2 = getlcd(root, n2);
        return dist1 + dist2;
    }

    public static int getlcd(TreeNode root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.val == n) {
            return 0;
        }
        int leftVal = getlcd(root.left, n);
        int rightVal = getlcd(root.right, n);
        if (leftVal == -1 && rightVal == -1) {
            return -1;
        } else if (leftVal == -1 && rightVal != -1) {
            return rightVal + 1;
        } else {
            return leftVal + 1;
        }
    }

    public static int KthAncestor(TreeNode root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.val == n) {
            return 0;
        }
        int leftVal = KthAncestor(root.left, n, k);
        int rightVal = KthAncestor(root.right, n, k);
        if (leftVal == -1 && rightVal == -1) {
            return -1;
        }
        int max = Math.max(leftVal, rightVal);
        if (max + 1 == k) {
            System.out.println(root.val);
        }
        return max + 1;
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        // int val = 15;
        // var t = tree.GetNode(3);
        // TreeNode root = new TreeNode(4);
        // tree.insertion(root, 2);
        // tree.insertion(root, 3);
        // tree.insertion(root, 2);
        // tree.insertion(root, 1);
        // tree.insertion(root, 3);
        // tree.insertion(root, 6);
        // // System.out.println(root.val);
        // System.out.println(root.right.val);
        // System.out.println("preoreder");
        // tree.preOrder(root);
        // System.out.println("inoreder");
        // System.out.println(tree.inorderTraversal(root));
        // System.out.println("postoreder");
        // tree.postOrder(root);
        // tree.BFS(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.NodeCount(root));
        // System.out.println(tree.heightRecursion(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(sumNode(root));
        // System.out.println(diameter2(root).d);
        // topView(root);
        // kthLevel(root, 0, 1);
        // //System.out.println(lowestCommonAncester(root, 90, 10));
        // System.out.println(lowestCommonAncester2(root, 90, 10).val);
        // System.out.println(minDistanceTwoNodes(root, 90, 10));
        // KthAncestor(root, 1, 2);
        int array[] = { 2, 3, 4, 5, 6 };
        TreeNode root = new TreeNode(array[0]);
        createTreeArray(root, array);
        // System.out.print(minDepth(root));

    }

    public static int getMinimumDifference(TreeNode root) {
        int b = helper(root.right, Integer.MAX_VALUE);
        int a = helper(root.left, Integer.MAX_VALUE);
        return Math.min(a, b);

    }

    public static int helper(TreeNode root, int mindiff) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.left != null) {
            int diff1 = Math.abs(root.val - root.left.val);
            mindiff = Math.min(diff1, mindiff);
            helper(root.left, mindiff);
        }
        if (root.right != null) {
            int diff2 = Math.abs(root.val - root.right.val);
            mindiff = Math.min(diff2, mindiff);
            helper(root.right, mindiff);

        }
        return mindiff;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helperMinDepth(root, 1);
    }

    public static int helperMinDepth(TreeNode root, int level) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return level;
        }
        int left = helperMinDepth(root.right, level + 1);
        int right = helperMinDepth(root.left, level + 1);
        return Math.min(left, right);
    }

    public static void createTreeArray(TreeNode root, int[] array) {
        for (int i = 1; i < array.length; i++) {
            insertion(root, array[i]);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        helperDistance(root, target, list, k, 1);
        return list;
    }

    private void helperDistance(TreeNode root, TreeNode target, ArrayList<Integer> list, int k, int i) {
        if (root == null) {
            return;
        }

        if (i == k) {
            list.add(root.val);
        }

        if (root.val == target.val) {
            helperDistance(root, target, list, k, i + 1);
        }
    }
}
