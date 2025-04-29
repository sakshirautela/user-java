import java.util.Arrays;

public class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int minReward = 1;
        int maxReward = Arrays.stream(nums).max().getAsInt();
        int totalHouses = nums.length;
        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int index = 0; index < totalHouses; ++index) {
                if (nums[index] <= midReward) {
                    possibleThefts += 1;
                    index++;
                }
            }

            if (possibleThefts >= k)
                maxReward = midReward;
            else
                minReward = midReward + 1;
        }

        return minReward;
    }

    public int minCapability2(int[] a, int k) {
        int n = a.length;
        int lo = Integer.MAX_VALUE;

        for (int x : a)
            lo = Math.min(lo, x);
        int hi = 0;
        for (int x : a)
            hi = Math.max(hi, x);

        int ans = 0;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            int max = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] <= mid) {
                    i++;
                    max++;
                }
            }

            if (max >= k) {
                hi = mid - 1;
                ans = mid;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}
