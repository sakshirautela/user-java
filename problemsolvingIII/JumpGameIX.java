package problemsolvingIII;

import java.util.Arrays;

public class JumpGameIX {
    static void main() {

        int[] arr = maxValue(new int[]{2, 3, 1});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] premax = new int[n];
        int[] premin = new int[n];
        int[] sufmax = new int[n];
        int[] sufmin = new int[n];
        Arrays.fill(sufmin, Integer.MAX_VALUE);
        Arrays.fill(premin, Integer.MAX_VALUE);
        sufmin[n - 1] = nums[n - 1];
        sufmax[n - 1] = nums[n - 1];
        premin[0] = nums[0];
        premax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > sufmax[i]) {
                premax[i] = nums[i];
            }else {
                premin[i] = nums[i];
            }
            premax[i] = Math.max(premax[i], premax[i - 1]);
            premin[i] = Math.min(premin[i], premin[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < sufmin[i]) {
                sufmin[i] = nums[i];
            }else{
                sufmax[i] = nums[i];
            }
            sufmin[i] = Math.min(sufmin[i], sufmin[i + 1]);
            sufmax[i] = Math.max(sufmax[i], sufmax[i + 1]);
        }
        for(int i=0;i<n;i++){
            ans[i] = sufmin[i];
        }
        return ans;
    }
}