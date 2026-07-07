package problemsolvingIII;

public class RotateFunction {
    static void main() {
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
    }

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int pre=0;
        int sum=0;
        for(int i=0;i<n;i++) {
            pre+=i*nums[i];
            sum+=nums[i];
        }
        int result=pre;
//        System.out.print(pre+" ");
        for(int i=1;i<n;i++) {
            result=Math.max(result, pre+sum-n*nums[n-i]);
            pre=pre+sum-n*nums[n-i];
//            System.out.print(pre+" ");
        }
//        System.out.println();
        return result;
    }
        public static int maxRotateFunctionTLE(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result=Math.max(result,maxRotateFunctionHelper(nums,i));
        }
        return result;
    }
        public static int maxRotateFunctionHelper(int[] nums,int idx) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result+=((i+1+idx)%n)*nums[i];
        }
        return result;
    }
    public int maxRotateFunction3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int F = 0;
        // Step 1: Calculate the sum of all elements and the initial F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }
        int max = F;
        // Step 2: Calculate F(1) to F(n-1) using the recurrence relation
        // Apply formula: F(k) = F(k-1) + sum - n * last_element_of_prev_rotation
        for (int i = 1; i < n; i++) {
            F = F + sum - n * nums[n - i];
            // Update max if F is larger
            if (max < F) {
                max = F;
            }
        }
        return max;
    }
}