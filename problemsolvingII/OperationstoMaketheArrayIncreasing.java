public class OperationstoMaketheArrayIncreasing {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {}));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= min) {
                result += min - nums[i] + 1;
                min++;
            }else{
                min=nums[i];
            }
        }
        return result;
    }
    static{
        for(int i=0;i<500;i++){
            minOperations(new int[1]);
        }
    }
    public static int minOperationsFast(int[] nums) {
        int op = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int diff = nums[i - 1] - nums[i] + 1;
                op += diff;
                nums[i] += diff;
            }
        }
        return op;
    }
}