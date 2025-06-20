import java.util.*;

public class ZeroArrayTransformationIV {
    public static void main(String[] args) {

    }

    public int minZeroArray(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] deltaArray = new int[nums.length + 1];
        int operations = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            operations += deltaArray[i];
            while (j < queries.length && queries[j][0] == i) {
                heap.offer(new int[]{queries[j][1],queries[j][2]});
                j++;
            }
            while (operations < nums[i] && !heap.isEmpty() && heap.peek()[0] >= i) {
                operations += 1;
                int[] a=heap.poll();
                deltaArray[a[0]+1] -= a[1];
            }
            if (operations < nums[i]) {
                return -1;
            }
        }
        return heap.size();
    }
}