import java.util.PriorityQueue;
public class KthElementinMatrix {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{}},4));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                pq.add(matrix[i][j]);
            }
        }
        while (k>0) {
            pq.remove();
        }
        return pq.peek();
    }
}