import java.util.Arrays;
public class FindSubsequenceofLengthKWiththeLargestSum {
    public static void main(String[] args) {
        int[] res=maxSubsequence(new int[]{},4);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] values = new int[n][2]; 
        for (int i = 0; i < n; ++i) {
            values[i][0] = i;
            values[i][1] = nums[i]; 
        }
        Arrays.sort(values, (a,b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(values, 0, k, (a,b) -> Integer.compare(a[0],b[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = values[i][1];
        }
        return res;
    }
    public int[] maxSubsequenceFast(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);

        Arrays.sort(sorted);

        int threshold = sorted[n - k];
        int thresholdCnt = 0;
        for (int i = n - k; i < n; i++) {
            if (sorted[i] == threshold) {
                thresholdCnt++;
            }
        }

        int[] ans = new int[k];

        int p = 0;
        for (int num : nums) {
            if (num > threshold) {
                ans[p++] = num;
            } else if (num == threshold && thresholdCnt > 0) {
                ans[p++] = num;
                thresholdCnt--;
            }
            if (p== k) {
                break;
            }
        }

        return ans;
    }
}