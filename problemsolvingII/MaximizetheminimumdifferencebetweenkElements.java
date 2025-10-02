public class MaximizetheminimumdifferencebetweenkElements {
    public static void main(String[] args) {
        System.out.println(maxMinDiff(new int[]{2, 2, 5, 6}, 3));
    }

    public static int maxMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        int res = Math.abs(arr[0] - arr[1]);
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff > res) {
                res = diff;
            }
        }
        return res;
    }

}
