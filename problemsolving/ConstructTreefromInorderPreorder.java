
public class ConstructTreefromInorderPreorder {
    static class Node {
        int data;
        Node left, right;
    
        public Node(int key) {
            data = key;
            left = right = null;
        }
    }
    static int search(int[] inorder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }

    static Node buildTreeRecur(int[] inorder, int[] preorder, int[] preIndex, int left, int right) {
        if (left > right)
            return null;

        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;
        Node root = new Node(rootVal);
        int index = search(inorder, rootVal, left, right);
        root.left = buildTreeRecur(inorder, preorder, preIndex, left, index - 1);
        root.right = buildTreeRecur(inorder, preorder, preIndex, index + 1, right);

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        int[] preIndex = {0};
        return buildTreeRecur(inorder, preorder, preIndex, 0, preorder.length - 1);
    }
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{}, new int[]{}));
    }
}
