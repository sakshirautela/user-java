public class MaximumSubarrayWithEqualProducts {
    public static void main(String[] args) {
        System.out.println(maxLength(new int[] {1,2,1,2,1,1,1}));
    }

    public static int maxLength(int[] nums) {
        int maxLength = 0;  // Keep track of the longest valid subarray
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            int lcm = nums[i];
            int gcd = nums[i];
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                gcd = getGCD(gcd, nums[j]);
                lcm = getLCM(lcm, nums[j]);
                if (product == gcd * lcm) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private static int getLCM(int u, int v)
    {
        return (u / getGCD(u, v)) * v;
    }

    private static int getGCD(int i, int j) {
        if(i==0){
            return j;
        }
        return getGCD(j%i, i);
    }
}