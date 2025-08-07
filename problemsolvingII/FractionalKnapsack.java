import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsack {
    public static void main(String[] args) {
        System.out.println(fractionalKnapsack(new int[]{8, 2, 10, 1, 9, 7, 2, 6, 4, 9}, new int[]{10, 1, 7, 7, 5, 1, 8, 6, 8, 7}, 21));
    }


    static double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n = values.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> Double.compare(b[2],a[2]));
        for (int i = 0; i < n; i++) {
            pq.add(new double[]{values[i], weights[i], (double) values[i] /weights[i]});
        }
        double result = 0;
        while (!pq.isEmpty()) {
            double[] curr = pq.remove();
            if (W >= curr[1]) {
                result += curr[0];
                W -= (int) curr[1];
            } else if (W > 0) {
                result +=(curr[2]) * W;
                break;
            }
        }
        return result;
    }
}
