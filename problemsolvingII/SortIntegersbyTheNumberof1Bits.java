import java.util.PriorityQueue;

public class SortIntegersbyTheNumberof1Bits {
    static void main() {
        System.out.println();
    }

    public static int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1]==b[1])?a[0]-b[0]:a[1] - b[1]);
        for (int j : arr) {
            pq.offer(new int[]{j, Integer.bitCount(j)});
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            arr[idx++] = pq.poll()[0];
        }
        return arr;
    }
}
