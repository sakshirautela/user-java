
public class FindthePowerofKSizeSubarraysI {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            boolean ifconsicutive = true;
            for (int j = 1; j < k; j++) {
                if (nums[i + j] - 1 != nums[i + j - 1]) {
                    ifconsicutive = false;
                    break;
                }
            }
            if (ifconsicutive) {
                res[i] = nums[i + k - 1];
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    public int[] resultsArray2(int[] nums, int k) {
        int n = nums.length;
        int[] subArrPower = new int[n - k + 1];
        int inconsecutiveElementCount = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                inconsecutiveElementCount++;
            }
        }
        int start = 0, end = k - 1;
        while (end < n) {
            subArrPower[start] = inconsecutiveElementCount == 0 ? nums[end] : -1;
            if (start < n - 1 && nums[start] != nums[start + 1] - 1) {
                inconsecutiveElementCount--;
            }
            start++;
            if (end < n - 1 && nums[end + 1] != nums[end] + 1) {
                inconsecutiveElementCount++;
            }
            end++;
        }
        return subArrPower;

    }

    public static void main(String args[]) {
        int[] res = (resultsArray(new int[] { 1, 3, 4 }, 2));
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
