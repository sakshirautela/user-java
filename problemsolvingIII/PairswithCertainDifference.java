package problemsolvingIII;

import java.util.Arrays;

public class PairswithCertainDifference {
    static void main() {
        System.out.println(sumDiffPairs(new int[]{3, 5, 10, 15, 17, 12, 9}, 4));
    }

    public static int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;
        for (int i = n - 1; i>=1;i--) {
            if (arr[i] - arr[i-1] < k) {
                res += arr[i - 1] + arr[i];
                i--;
            }
        }
        return res;
    }
}
