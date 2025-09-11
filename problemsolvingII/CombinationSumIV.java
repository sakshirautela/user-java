public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int result = 0;
        combinationSum4Helper(nums, target, nums.length, 0, 0);
        return result;
    }

    private void combinationSum4Helper(int[] nums, int target, int length, int i, int i1) {
    }
}
