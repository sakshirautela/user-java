import java.util.*;

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

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

    public void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

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
    // public static diameter2(TreeNode root){
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

    public static ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Info> q = new ArrayDeque<Info>();
        int hd = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        q.add(new Info(root, hd));
        while (!q.isEmpty()) {
            Info a = q.poll();
            hm.put(a.hd, a.node.val);
            if (a.node.left != null) {
                q.add(new Info(a.node.left, a.hd - 1));
            }
            if (a.node.right != null) {
                q.add(new Info(a.node.right, a.hd + 1));
            }
        }
        for (int s : hm.keySet()) {
            al.add(hm.get(s));
        }
        return al;
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

    @SuppressWarnings("unused")
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
        // BinaryTree tree = new BinaryTree();
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
        int array[] = {2, 3, 4, 5, 6};
        TreeNode root = new TreeNode(array[0]);
        createTreeArray(root, array);
        // System.out.print(minDepth(root));

    }

    public static int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return res;
    }

    public static void helpergetMinimumDifference(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        helpergetMinimumDifference(root.left, list);
        list.add(root.val);
        helpergetMinimumDifference(root.right, list);
    }

    static int min = Integer.MAX_VALUE;
    static Integer prev = null;

    public int getMinimumDifference2(TreeNode root) {
        getMinimumDifferenceHelper(root);
        return min;
    }

    public static void getMinimumDifferenceHelper(TreeNode root) {
        if (root == null)
            return;
        getMinimumDifferenceHelper(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifferenceHelper(root.right);
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val && isSymmetricHelper(node1.left, node2.right)
                && isSymmetricHelper(node1.right, node2.left));
    }

    ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        al.add(root.data);
        q.offer(null);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    al.add(q.peek().data);
                    q.offer(null);

                }
            } else {
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return al;
    }

    ArrayList<Integer> leftView2(Node root) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node peek = q.peek();
            list.add(peek.data);
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return list;
    }

    static int sum;

    public static int treePathsSum(Node root) {
        // add code here.
        sum = 0;
        treePathsSumHelper(root, 0);
        return sum;
    }

    private static void treePathsSumHelper(Node root, int val) {
        if (root == null) {
            return;
        }
        val = val * 10 + root.data;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if (root.left != null) {
            treePathsSumHelper(root.left, val);
        }
        if (root.right != null) {
            treePathsSumHelper(root.right, val);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelsHelper(root.left, root.right, 0);
        return root;
    }

    private void reverseOddLevelsHelper(TreeNode leftChild, TreeNode rightChild, int i) {
        if (leftChild == null || rightChild == null) {
            return;
        }
        if (i % 2 == 0) {
            int temp = rightChild.val;
            rightChild.val = leftChild.val;
            leftChild.val = temp;
        }
        reverseOddLevelsHelper(leftChild.left, rightChild.right, i + 1);
        reverseOddLevelsHelper(leftChild.right, rightChild.left, i + 1);
    }

    private int indexOf(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == ele)
                return i;

        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int minSwaps(int[] arr, int N) {
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        for (int i = 0; i < N; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }
        return ans;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.peek();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                curr = q.remove();
                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }

            int[] arr = new int[q.size()];
            int k = 0;
            for (TreeNode num : q)
                arr[k++] = num.val;

            count += minSwaps(arr, k);
        }
        return count;
    }

    // Constants for bit manipulation
    final int SHIFT = 20;
    final int MASK = 0xFFFFF;

    public int minimumOperations2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int swaps = 0;

        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long[] nodes = new long[levelSize];

            // Store node values with encoded positions
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // Encode value and index: high 20 bits = value, low 20 bits = index
                nodes[i] = ((long) node.val << SHIFT) + i;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            // Sort nodes by their values (high 20 bits)
            Arrays.sort(nodes);

            // Count swaps needed to match indices with original positions
            for (int i = 0; i < levelSize; i++) {
                int origPos = (int) (nodes[i] & MASK);
                if (origPos != i) {
                    // Swap nodes and decrement i to recheck current position
                    long temp = nodes[i];
                    nodes[i--] = nodes[origPos];
                    nodes[origPos] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    ArrayList<Integer> li = new ArrayList<Integer>();

    boolean isBST(Node root) {
        // code here.
        if (root == null) {
            return true;
        }
        isBSTHaleper(root);
        for (int index = 0; index < li.size() - 1; index++) {
            if (li.get(index) > li.get(index + 1)) {
                return false;
            }
        }
        return true;
    }

    private void isBSTHaleper(Node root) {
        if (root == null) {
            return;
        }
        isBST(root.left);
        li.add(root.data);
        isBST(root.right);
    }

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> li = new ArrayList<ArrayList<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                li.add(al);
                al = new ArrayList<>();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                al.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return li;
    }

    static class dia {
        int daimeter;
        int height;

        public dia(int d, int h) {
            this.daimeter = d;
            this.height = h;
        }
    }

    int diameter(Node root) {
        // Your code here
        dia d = diameterHelepr(root);
        return Math.max(d.daimeter, d.height);
    }

    static dia diameterHelepr(Node root) {
        // Your code here
        if (root == null) {
            return new dia(0, 0);
        }
        dia l = diameterHelepr(root.left);
        dia r = diameterHelepr(root.right);
        int d = Math.max(l.daimeter + r.daimeter + 1, l.height + r.height + 1);
        int h = l.height + r.height + 1;
        return new dia(d, h);
    }

    void mirror(Node node) {
        // Your code here
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    private void boundaryTraversalLeft(Node node, ArrayList<Integer> al) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        al.add(node.data);
        if (node.left != null) {
            boundaryTraversalLeft(node.left, al);
        } else {
            boundaryTraversalLeft(node.right, al);
        }
    }

    private void boundaryTraversalLeaf(Node node, ArrayList<Integer> al) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            al.add(node.data);
        }
        boundaryTraversalLeaf(node.left, al);
        boundaryTraversalLeaf(node.right, al);
    }

    private void boundaryTraversalRight(Node node, ArrayList<Integer> al) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        if (node.right != null) {
            boundaryTraversalRight(node.right, al);
        } else {
            boundaryTraversalRight(node.left, al);
        }
        al.add(node.data);
    }

    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        if (!(node.left == null && node.right == null)) {
            al.add(node.data);
        }
        boundaryTraversalLeft(node.left, al);
        boundaryTraversalLeaf(node, al);
        boundaryTraversalRight(node.right, al);
        return al;
    }

    int findMaxSum(Node node) {
        // your code goes here
        int[] res = {node.data};
        findMaxSumUtil(node, res);
        return res[0];
    }

    private int findMaxSumUtil(Node root, int[] res) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, findMaxSumUtil(root.left, res));
        int r = Math.max(0, findMaxSumUtil(root.right, res));
        res[0] = Math.max(res[0], l + r + root.data);
        System.out.println(res[0] + "," + r + "," + l);
        return root.data + Math.max(l, r);
    }

    private void solve(Node root, int k, int currSum, HashMap<Integer, Integer> prefixSum, int[] count) {
        if (root == null)
            return;

        currSum += root.data;

        if (currSum == k)
            count[0]++;

        if (prefixSum.containsKey(currSum - k)) {
            count[0] += prefixSum.get(currSum - k);
        }

        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        solve(root.left, k, currSum, prefixSum, count);
        solve(root.right, k, currSum, prefixSum, count);

        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
    }

    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int[] count = new int[1];
        solve(root, k, 0, prefixSum, count);
        return count[0];
    }

    public int kthSmallest(Node root, int k) {
        // Write your code here
        int[] count = {0, -1};
        kthSmallestUtil(root, count, k);
        return count[1];
    }

    private void kthSmallestUtil(Node root, int[] count, int k) {
        if (root == null) {
            return;
        }
        kthSmallestUtil(root.left, count, k);
        count[0]++;
        if (count[0] == k) {
            count[1] = root.data;
            return;
        }
        kthSmallestUtil(root.right, count, k);
    }

    boolean findTarget(Node root, int target) {
        // Write your code here
        return helper(root, root, target);
    }

    boolean helper(Node root, Node current, int target) {
        if (root == null || current == null) {
            return false;
        }
        if (findNode(root, current, target - current.data)) {
            return true;
        }
        return helper(root, current.left, target)
                || helper(root, current.right, target);
    }

    boolean findNode(Node root, Node current, int target) {
        if (root == null || root == current) {
            return false;
        }
        if (root.data == target) {
            return true;
        } else if (root.data > target) {
            return findNode(root.left, current, target);
        } else {
            return findNode(root.right, current, target);
        }
    }

    static Node prevs, first, second;

    void correctBST(Node root) {
        prevs = first = second = null;
        solve(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    void solve(Node root) {
        if (root == null)
            return;
        solve(root.left);
        if (prev != null) {
            if (first == null) {
                if (root.data < prevs.data) {
                    first = prevs;
                    second = root;
                }
            } else {
                if (root.data < prevs.data)
                    second = root;
            }
        }
        prevs = root;
        solve(root.right);
    }

    Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        if (root == null) {
            return null;
        }
        if (root.data > n1.data && root.data > n2.data) {
            return LCA(root.left, n1, n2);
        }
        if (root.data < n1.data && root.data < n2.data) {
            return LCA(root.right, n1, n2);
        }
        return root;
    }

    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        serializeUtil(root, al);
        return al;
    }

    private void serializeUtil(Node root, ArrayList<Integer> al) {
        if (root == null) {
            al.add(-1);
            return;
        }
        al.add(root.data);
        serializeUtil(root.left, al);
        serializeUtil(root.right, al);
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here'
        int[] idx = new int[]{0};
        return deSerializeUtil(arr, idx);

    }

    private Node deSerializeUtil(ArrayList<Integer> al, int[] idx) {
        if (al.get(idx[0]) == -1) {
            idx[0]++;
            return null;
        }
        Node newNode = new Node(al.get(idx[0]));
        idx[0]++;
        newNode.left = deSerializeUtil(al, idx);
        newNode.right = deSerializeUtil(al, idx);
        return newNode;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaDeepestLeavesHelper(root);
    }

    private TreeNode lcaDeepestLeavesHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (lheight == rheight) {
            return root;
        }
        if (lheight > rheight) {
            return lcaDeepestLeavesHelper(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    int maxPathSum(Node root) {
        int max[] = {Integer.MIN_VALUE};
        int res = maxPathSum(root, max);
        if (root.left == null || root.right == null) {
            return Math.max(max[0], res);
        }
        return max[0];

    }

    static int maxPathSum(Node node, int max[]) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathSum(node.left, max));
        int right = Math.max(0, maxPathSum(node.right, max));
        max[0] = (Math.max(left + right + node.data, max[0]));
        return Math.max(left, right) + node.data;
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        addPaths(result, root, new ArrayList<Integer>());
        return result;
    }

    private static void addPaths(ArrayList<ArrayList<Integer>> result, Node root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        al.add(root.data);
        addPaths(result, root.left, al);
        addPaths(result, root.right, al);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(al));
        }
        al.remove(al.size() - 1);
    }

    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (root == null) {
            return al;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean spiral = true;
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (spiral) {
                    Collections.reverse(temp);
                }
                al.addAll(temp);
                temp = new ArrayList<Integer>();
                spiral = !spiral;
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                temp.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return al;
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> al = new ArrayList<Node>();
        Node pre = new Node(-1);
        Node suc = new Node(-1);
        findPreSucHelper(root, key, pre, suc);
        al.add(pre);
        al.add(suc);
        return al;
    }

    private void findPreSucHelper(Node root, int key, Node pre, Node suc) {
        if (root == null) {
            return;
        }
        if (root.data < key && pre.data < root.data) {
            pre.data = root.data;
        }
        if (root.data > key && (suc.data == -1 || suc.data > root.data)) {
            suc.data = root.data;
        }
        findPreSucHelper(root.left, key, pre, suc);
        findPreSucHelper(root.right, key, pre, suc);
    }

    static int maxDistance = 0;

    public static int minTime(Node root, int target) {
        // code here
        minTimeHelper(root, target);
        return maxDistance;
    }

    private static int minTimeHelper(Node root, int start) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int leftDepth = minTimeHelper(root.left, start);
        int rightDepth = minTimeHelper(root.right, start);

        if (root.data == start) {
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }

        return depth;
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> al = new ArrayList<Integer>();
        KDistanceNodesHelper(root, target, k, 0, al);
        return al;
    }

    private static void KDistanceNodesHelper(Node root, int target, int k, int depth, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        if (depth == k) {
            al.add(root.data);
        }
        if (root.data == target) {
            KDistanceNodesHelper(root.left, target, k, 1, al);
            KDistanceNodesHelper(root.right, target, k, 1, al);
        } else {
            KDistanceNodesHelper(root.left, target, k, depth + 1, al);
            KDistanceNodesHelper(root.right, target, k, depth + 1, al);
        }
    }

    public ArrayList<Integer> leafNodes(int[] preorder) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.add(preorder[i]);
            } else {
                if (st.peek() < preorder[i]) {
                    int s = st.peek();
                    int a = 0;
                    while (!st.isEmpty() && st.peek() < preorder[i]) {
                        a++;
                        st.pop();
                    }
                    if (a >= 2) {
                        al.add(s);
                    }
                }
                st.add(preorder[i]);
            }
        }
        if (!st.isEmpty()) {
            al.add(st.peek());
        }
        return al;
    }

    static void sumOfRootToLeaf(Node root, int sum,
                                int length, int[] maxLen,
                                int[] maxSum) {

        // Base case: if the current node is null
        if (root == null) {

            // Checking if the current path has a longer
            // length and update maxLen and maxSum
            // accordingly
            if (length > maxLen[0]) {
                maxLen[0] = length;
                maxSum[0] = sum;
            }

            // If the lengths are equal, check if the
            // current sum is greater and update maxSum if
            // necessary
            else if (length == maxLen[0]
                    && sum > maxSum[0]) {
                maxSum[0] = sum;
            }
            return;
        }

        // Recursively calculating the sum of
        // the left and right subtrees
        sumOfRootToLeaf(root.left, sum + root.data,
                length + 1, maxLen, maxSum);
        sumOfRootToLeaf(root.right, sum + root.data,
                length + 1, maxLen, maxSum);
    }

    // Function to calculate the sum of the longest root to
    // leaf path
    static int sumOfLongRootToLeafPath(Node root) {

        // Base case: if the tree is empty
        if (root == null)
            return 0;

        // Initializing the variables to
        // store the maximum length and sum
        int[] maxSum = {Integer.MIN_VALUE};
        int[] maxLen = {0};

        // Calling the utility function
        sumOfRootToLeaf(root, 0, 0, maxLen, maxSum);

        // Returning the maximum sum
        return maxSum[0];
    }

    public int findMaxFork(Node root, int k) {
        // code here.
        int[] res = {-1};
        findMaxForkHelper(root, k, res);
        return res[0];
    }

    private void findMaxForkHelper(Node root, int k, int[] res) {
        if (root == null) {
            return;
        }
        if (root.data <= k) {
            res[0] = Math.max(res[0], root.data);
        }
        findMaxForkHelper(root.left, k, res);
        findMaxForkHelper(root.right, k, res);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> map = new ArrayList<>();
        int min = 0;
        verticalTraversalHelper(root, map, 0, 0);
        map.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        int prev = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        int idx = -1;
        for (int[] nodes : map) {
            if (prev != nodes[0]) {
                res.add(new ArrayList<>());
                idx++;
                prev = nodes[0];
            }
            res.get(idx).add(nodes[2]);
        }
        return res;
    }

    private void verticalTraversalHelper(TreeNode root, List<int[]> map, int r, int c) {
        if (root == null) {
            return;
        }
        map.add(new int[]{c, r, root.val});
        verticalTraversalHelper(root.left, map, r + 1, c - 1);
        verticalTraversalHelper(root.right, map, r + 1, c + 1);
    }
    // /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {

//     public class QEntry{
//         TreeNode node;
//         int index;

//         public QEntry(int index, TreeNode node){
//             this.node = node;
//             this.index = index;
//         }
//     }

//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         Queue<QEntry> q = new LinkedList<>();
//         List<List<Integer>> ans = new ArrayList<>();
//         Map<Integer, List<Integer>> mainMp = new TreeMap<>();
//         if(root == null) {
//             return ans;
//         }
//         q.add(new QEntry(0, root));
//         while(!q.isEmpty()) {
//             int n = q.size();
//             Map<Integer, List<Integer>> mp = new TreeMap<>();
//             for(int i=0; i<n; i++) {
//                 QEntry entry = q.poll();
//                 if(mp.get(entry.index) != null) {
//                     mp.get(entry.index).add(entry.node.val);
//                 } else {
//                     mp.put(entry.index, new ArrayList<>(List.of(entry.node.val)));
//                 }
//                 if(entry.node.left != null) {
//                     q.add(new QEntry(entry.index-1, entry.node.left));
//                 }
//                 if(entry.node.right != null) {
//                     q.add(new QEntry(entry.index+1, entry.node.right));
//                 }
//             }
//             for(Map.Entry<Integer, List<Integer>> mpEntry : mp.entrySet()) {
//                 int key = mpEntry.getKey();
//                 Collections.sort(mpEntry.getValue());
//                 if(mainMp.get(key) != null) {
//                     mainMp.get(key).addAll(mpEntry.getValue());
//                 } else {
//                     mainMp.put(key, mpEntry.getValue());
//                 }
//             }
//         }
//         for(Map.Entry<Integer, List<Integer>> mpEntry : mainMp.entrySet()) {
//             ans.add(mpEntry.getValue());
//         }
//         return ans;
//     }
// }

// import java.util.*;

// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<int[]> nodes = new ArrayList<>();

//         // Step 1: DFS to collect all (col, row, val)
//         dfs(root, 0, 0, nodes);

//         // Step 2: Sort by col, then row, then value
//         nodes.sort((a, b) -> {
//             if (a[0] != b[0]) return Integer.compare(a[0], b[0]);     // col
//             if (a[1] != b[1]) return Integer.compare(a[1], b[1]);     // row
//             return Integer.compare(a[2], b[2]);                       // value
//         });

//         List<List<Integer>> result = new ArrayList<>();
//         int prevCol = Integer.MIN_VALUE;

//         // Step 3: Group by column
//         for (int[] node : nodes) {
//             int col = node[0], val = node[2];
//             if (col != prevCol) {
//                 result.add(new ArrayList<>());
//                 prevCol = col;
//             }
//             result.get(result.size() - 1).add(val);
//         }

//         return result;
//     }

//     // DFS helper to collect column, row, and value
//     private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
//         if (node == null) return;
//         nodes.add(new int[]{col, row, node.val});
//         dfs(node.left, row + 1, col - 1, nodes);   // Left child
//         dfs(node.right, row + 1, col + 1, nodes);  // Right child
//     }
// }

    /*    class Solution {
            public List<List<Integer>> verticalTraversal(TreeNode root) {
                if (root == null) {
                    return new LinkedList<>();
                }

                return new MyHack(root);
            }
        }

        class MyHack extends LinkedList<List<Integer>> {
            TreeNode root;
            Map<Integer, List<LeveldValue>> columns;

            MyHack(TreeNode root) {
                this.root = root;
                this.columns = null;
            }

            public int size() {
                if (columns == null) {
                    columns = new HashMap<>();

                    Queue<TreeNodeWithColumn> bfs = new LinkedList<>();

                    int minColumn = 0;
                    bfs.add(new TreeNodeWithColumn(root, 0, 0));

                    while(!bfs.isEmpty()) {
                        TreeNodeWithColumn nextTuple = bfs.poll();
                        TreeNode node = nextTuple.node;
                        int nodeColumn = nextTuple.column;
                        List<LeveldValue> nodesInLevel = columns.computeIfAbsent(nodeColumn, (l) -> new LinkedList<>());
                        nodesInLevel.add(new LeveldValue(node.val, nextTuple.level));

                        if (node.left != null) {
                            bfs.add(new TreeNodeWithColumn(node.left, nodeColumn - 1, nextTuple.level + 1));
                        }

                        if (node.right != null) {
                            bfs.add(new TreeNodeWithColumn(node.right, nodeColumn + 1, nextTuple.level + 1));
                        }

                        // System.out.println("visit= " + node.val+ ", l="+nodeColumn + ", nodes=" + nodesInLevel + ", q=" + bfs);

                        minColumn = Math.min(nodeColumn, minColumn);
                    }

                    while(columns.containsKey(minColumn)) {
                        List<LeveldValue> column = columns.get(minColumn);
                        Collections.sort(column);

                        super.add(column.stream().map(LeveldValue::getValue).toList());

                        minColumn += 1;
                    }
                }

                return super.size();
            }
        }

        class TreeNodeWithColumn {
            TreeNode node;
            int column;
            int level;

            TreeNodeWithColumn(TreeNode node, int column, int level) {
                this.node = node;
                this.column = column;
                this.level = level;
            }

            public String toString() {
                return "node(val=" + node.val + ", col=" + column + ")";
            }
        }

        class LeveldValue implements Comparable<LeveldValue> {
            int val;
            int level;

            LeveldValue(int val, int level) {
                this.val = val;
                this.level = level;
            }

            int getValue() {
                return val;
            }

            public int compareTo(LeveldValue o) {
                if (level == o.level) {
                    return Integer.compare(val, o.val);
                }

                return Integer.compare(level, o.level);
                }
            }*/
    static TreeNode result;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int a= subtreeWithAllDeepestHelper(root);
        subtreeWithAllDeepestHelper2(root,a-1);
        if(result==null){
            return root;
        }
        return  result;
        
    }

    private void subtreeWithAllDeepestHelper2(TreeNode root, int i) {
        if(i==0){
            if(root.left!=null && root.right!=null){
                result=root;
            }else if(root.left!=null){
                result=root.left;
            }else if(root.right!=null){
                result=root.right;
            }
                return;
        }
        if(root==null){
            return;
        }
        subtreeWithAllDeepestHelper2(root.left,i-1);
        subtreeWithAllDeepestHelper2(root.right,i-1);
    }

    private int subtreeWithAllDeepestHelper(TreeNode root) {
        if(root==null ){
            return 0;
        }
        return Math.max(subtreeWithAllDeepestHelper(root.left),subtreeWithAllDeepestHelper(root.right))+1;
    }
}