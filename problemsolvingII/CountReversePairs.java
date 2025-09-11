import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountReversePairs {
    public static void main(String[] args) {
        System.out.println(countRevPairs(new int[]{3, 2, 4, 5, 1, 20}));
    }

    public static int countRevPairs(int[] arr) {
        // code here
        int n = arr.length;
        return mergersort(arr, 0, n - 1);
    }

    private static int mergersort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return mergersort(arr, left, mid)
                + mergersort(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        // Count reverse pairs
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // Merge sorted halves
        List<Integer> temp = new ArrayList<>();
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) temp.add(arr[l++]);
            else temp.add(arr[r++]);
        }
        while (l <= mid) temp.add(arr[l++]);
        while (r <= right) temp.add(arr[r++]);

        for (int i = left; i <= right; i++) {
            arr[i] = temp.get(i - left);
        }
        return count;
    }
}
