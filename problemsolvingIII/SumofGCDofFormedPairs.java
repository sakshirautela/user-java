package problemsolvingIII;

import java.util.Arrays;

public class SumofGCDofFormedPairs {
    public static void main(String[] args) {
        System.out.println(gcdSum(new int[]{1, 2, 3, 4}));
    }

    public static long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[n];
        prefixSums[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max == nums[i]) {
                prefixSums[i] = nums[i];
            } else {
                prefixSums[i] = gcd(max, nums[i]);
            }
        }
         long result=0;
        int i=0,j=n-1;
        Arrays.sort(prefixSums);
        while (i<j) {
            result+=gcd(prefixSums[i],prefixSums[j]);
            i++;
            j--;
        }
        return result;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
