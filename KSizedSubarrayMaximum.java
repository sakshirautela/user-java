import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSizedSubarrayMaximum {
    public static void main(String[] args) {
        System.out.println(maxOfSubarrays(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));
    }

    public static ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
       ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(
            Collections.reverseOrder());
        
        int n = arr.length;
        int l = 0;
        for (int r = 0; r < n; r++) {
            q.add(arr[r]);
            if (r - l + 1 == k) {
                res.add(q.peek());
                q.remove(arr[l++]);
            }
        }
        
        return res;
    }
}