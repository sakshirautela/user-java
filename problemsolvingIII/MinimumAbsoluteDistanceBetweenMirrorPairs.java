package problemsolvingIII;

import java.util.HashMap;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    static void main() {
        System.out.println(minMirrorPairDistance(new int[]{120,21}));
    }

    public static int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> reverse = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rev=0;
            int num = nums[i];
            while (num > 0) {
                rev= rev * 10 + num % 10;
                num /= 10;
            }
            if(reverse.containsKey(nums[i])){
                res = Math.min(res, i-reverse.get(nums[i]));
            }
            reverse.put(rev, i);
        }
        System.out.println(reverse);
        return res==Integer.MAX_VALUE?-1:res;
    }
}