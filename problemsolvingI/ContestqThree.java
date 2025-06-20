public class ContestqThree {
    public static void main(String[] args) {
        ContestqThree contest = new ContestqThree();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        for (long num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        long[] result = contest.resultArray(nums, k);
        for (long num : result) {
            System.out.print(num + " ");
        }
    }

    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];

        for (int start = 0; start < n; start++) {
            long product = 1;

            for (int end = start; end < n; end++) {
                product = (product * nums[end]) % k;
                int remainder = (int) product;
                result[remainder]++;
                
                // Optimization: If product is 0, all further products will also be 0 mod k
                if (product == 0) break;
            }
        }

        return result;
    }
}
