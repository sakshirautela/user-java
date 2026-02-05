public class TrinoicArrayI {
    static void main() {
        System.out.println(isTrionic(new int[]{2,1,3}));
    }

    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(nums[0]>=nums[1]){
            return false;
        }
        int count = 1;
        for (int i = 2; i < n-1; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++;
            }
        }
        return (count == 3);
    }
}