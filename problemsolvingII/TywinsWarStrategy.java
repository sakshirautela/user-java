import java.util.PriorityQueue;

public class TywinsWarStrategy {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int without = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % k == 0) {
                without++;
            } else {
                pq.add(k - (arr[i] % k));
            }
        }
        int lucky=(n%2==1)?n/2+1:n/2;
        int result = 0;
        while (!pq.isEmpty() && without <lucky) {
            result += pq.remove();
            without++;
        }
        return result;
    }
}
