public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{5,4,3,2,1})); // Output: 1
        System.out.println(maxChunksToSorted(new int[]{2,1,3,4,4})); // Output: 4
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n + 1];

        // leftMax[i] = max from 0 to i
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // rightMin[i] = min from i to end
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int chunks = 0;
        for (int i = 0; i < n; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                chunks++;
            }
        }

        return chunks;
    }
}
