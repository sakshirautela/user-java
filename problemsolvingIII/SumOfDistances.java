package problemsolvingIII;

import java.util.HashMap;

public class SumOfDistances {
    static void main() {
        long[] ans = distance(new int[]{1, 3, 1, 1, 2});
        for (long an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }

    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer, long[]> total = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (total.containsKey(nums[i])) {
                total.get(nums[i])[0] += i;
                total.get(nums[i])[1] += 1;
            } else {
                total.put(nums[i], new long[]{i, 1});
            }
        }
        HashMap<Integer, long[]> left = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (total.get(nums[i])[1] == 1) {
                ans[i] = 0;
            } else {
                if (left.containsKey(nums[i])) {
                    long[] lefts = left.get(nums[i]).clone();
                    ans[i] = Math.abs((i * lefts[1]) - lefts[0]);
                    long[] rights = total.get(nums[i]).clone();
                    rights[0] -= i + lefts[0];
                    rights[1] -= lefts[1];
                    rights[1]--;
                    ans[i] += Math.abs((i * rights[1]) - rights[0]);
                } else {
                    long[] rights = total.get(nums[i]).clone();
                    rights[0] -= i;
                    rights[1] -= 1;
                    ans[i] += Math.abs((i * rights[1]) - rights[0]);
                }
            }
            if (left.containsKey(nums[i])) {
                left.get(nums[i])[0] += i;
                left.get(nums[i])[1] += 1;
            } else {
                left.put(nums[i], new long[]{i, 1});
            }
        }
        return ans;
    }        public long[] distanceFast(int[] nums) {
            HashMap<Integer, long[]> HM = new HashMap<>(nums.length, 0.99f);
            for (int i = 0; i < nums.length; i++) {
                if (!HM.containsKey(nums[i])) {
                    HM.put(nums[i], new long[] { 0, 0, 1, i });
                } else {
                    long[] arr = HM.get(nums[i]);
                    arr[2]++;
                    arr[3] += i;
                }
            }
            long[] res = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                long[] arr = HM.get(nums[i]);
                arr[2]--;
                arr[3] -= i;
                res[i] = arr[3] + (arr[0] - arr[2]) * i;
                arr[0]++;
                arr[3] -= i;
            }
            return res;
        }
}