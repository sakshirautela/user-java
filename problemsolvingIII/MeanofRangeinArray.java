package problemsolvingIII;

import java.util.ArrayList;

public class MeanofRangeinArray {
    static void main() {
        System.out.println();
    }

    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            if (l == 0) {
                int sum = preSum[r];
                ans.add(sum / (r + 1));
            }else {
                int sum = preSum[r]-preSum[l-1];
                ans.add(sum / (r + 1-l));
            }
        }
        return ans;
    }
}
