import java.util.ArrayList;
import java.util.Collections;

public class KthSmallestNumberinMultiplicationTable {
    public static void main(String[] args) {
        System.out.println(kthSmallest(2,3,4));
    }
    public static int kthSmallest(int m, int n, int k) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr.add(i * j);
            }
        }
        
        Collections.sort(arr);
        
        return arr.get(k - 1);
    }
    // Java program to find Kth Smallest
// Number in Multiplication Table

    // Function to find the number of 
    // values less than equal to val.
    static int count(int val, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= m; ++i) {
            cnt += Math.min(val / i, n);
        }
        return cnt;
    }

    static int kthSmallest2(int m, int n, int k) {

        // Binary search to find the kth number
        int l = 1, h = m * n;
        while (l < h) {
            int mid = (l + h) / 2;
            if (count(mid, m, n) < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        // Return the kth smallest number
        return l; 
    }
}