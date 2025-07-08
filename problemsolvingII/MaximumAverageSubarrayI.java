public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[] {4,2,1,3,3}, 2));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double average = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += (nums[i]);
            average = sum;

            } else {
                sum+=nums[i]-nums[i-k];
                average = Math.max(average, sum );
            }
        }
        System.out.println(average);
        return average / k;
    }
}