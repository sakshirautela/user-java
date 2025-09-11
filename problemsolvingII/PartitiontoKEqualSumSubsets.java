public class PartitiontoKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        long mul=0;
        for (int i = 0; i < n; i++) {
            mul+=nums[i];
        }
        return true;
    }
}
