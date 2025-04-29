
public class MinimumOperationToMakeBinaryElementofArrayToEqualOne {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {}));
    }

    public int minOperations2(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] == 0) {

                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count += 1;
            }
        }
        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {

            return -1;
        }

        return count;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int flip = 0;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                flip++;
                nums[i + 1] = nums[i + 1] ^ 1;
                nums[i + 2] = nums[i + 2] ^ 1;
            }
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum == n) {
            return flip;
        }
        return -1;
    }
}
