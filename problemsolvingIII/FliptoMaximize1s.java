package problemsolvingIII;

public class FliptoMaximize1s {
    static void main() {
        System.out.println(maxOnes(new int[]{0, 1, 1, 0, 0, 1, 1, 1, 0, 0}));
    }

    static int maxOnes(int[] arr) {
        // code here
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (arr[i] == 1) {
                arr[i] = -1;
            } else {
                arr[i] = 1;
            }
        }
        int max = 0;
        int sum = 0;
        for (int j : arr) {
            sum += j;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max + total;
    }
}
