import java.util.ArrayList;
import java.util.PriorityQueue;

public class HffmanEncoding {
    static void main() {
        System.out.println(huffmanCodes("",new int[]{5, 9, 12, 13, 16, 45}));
    }
    static class Node implements Comparable<Node> {
        int idx;
        int sum;
        Node left, right;

        Node(int ch, int sum, Node left, Node right) {
            this.idx = ch;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.sum == o.sum) {
                return this.idx - o.idx;
            }
            return this.sum - o.sum;
        }
    }


    public static ArrayList<String> huffmanCodes(String s, int f[]) {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < f.length; i++) {
            pq.add(new Node(i, f[i], null, null));
        }
        System.out.println(pq);
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node(Math.min(right.idx, left.idx), right.sum + left.sum, left, right);
            pq.add(newNode);
        }
        Node root = pq.poll();
        ArrayList<String> res = new ArrayList<>();
        preOrder(res,root,"");
        return res;
    }

    private static void preOrder(ArrayList<String> res, Node root, String s) {
        if (root == null) {
            res.add(s);
            return;
        }
        if(root.left == null && root.right == null) {
            if(s.isEmpty()) {
                s="0";
            }
            res.add(s);
            return;
        }
        preOrder(res,root.left,s+"0");
        preOrder(res,root.right,s+"1");
    }
}
