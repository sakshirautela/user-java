public class MinimumEqualSumofTwoArraysAfterReplacingZeros {
    public static void main(String[] args) {
        System.out.println(minSum(new int[] {2,0,2,0}, new int[] {1,4}));
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int z1 = 0, z2 = 0;
        for (int i : nums1) {
            if (i == 0) {
                z1++;
                sum1++;
            }
            sum1 += i;
        }
        for (int i : nums2) {
            if (i == 0) {
                z2++;
                sum2++;
            }
            sum2 += i;
        }
        if((z1==0 && sum2>sum1)||(z2==0 && sum1>sum2)){
            return -1;
        }
        return Math.max(sum1,sum2);
    }
    public long minSum2(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long zeroCount1 = 0;

        for (int n: nums1) {
            sum1 += (long) n;
            zeroCount1 += n == 0 ? 1 : 0;
        }

        long sum2 = 0;
        long zeroCount2 = 0;

        for (int n: nums2) {
            sum2 += (long) n;
            zeroCount2 += n == 0 ? 1 : 0;
        }

        long minSum1 = sum1+zeroCount1;
        long minSum2 = sum2+zeroCount2;

        if (minSum1<minSum2 && zeroCount1 == 0) {
            return -1;
        }

        if (minSum1>minSum2 && zeroCount2 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }
}