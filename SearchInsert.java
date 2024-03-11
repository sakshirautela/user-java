public class SearchInsert {
    public static void main(String[] args) {
        int[] nums={-1,2,3,4,5};
        int target=0;
        System.out.println(searchInsert(nums, target));
    }
    
    public static int searchInsert(int[] nums, int target) {
        int near = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                near = i;
            }
        }
        if (target < nums[0]) {
            return 0;
        }
        return near + 1;
    }

}
