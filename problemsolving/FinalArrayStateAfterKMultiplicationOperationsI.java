
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static void main(String args[]) {
        int[] res = getFinalState(new int[] {}, 2, 4);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            int valueComparison = Integer.compare(a[0], b[0]);
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });
        for (

                int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }
        while (k > 0) {
            int[] curr = pq.remove();
            pq.add(new int[] { curr[0] * multiplier, curr[1] });
            k--;
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            nums[curr[1]] = curr[0];
        }
        return nums;
    }

    public int[] getFinalState2(int[] arr, int k, int multiplier) {
        int ans[] = new int[arr.length];
        while (k > 0) {
            int x = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[x]) {
                    x = i;
                }
            }
            arr[x] = arr[x] * multiplier;
            k--;
        }
        return arr;
    }
}
