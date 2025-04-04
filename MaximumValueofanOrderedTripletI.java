public class MaximumValueofanOrderedTripletI {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[] {}));
    }

    public static long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return res;
    }

    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        long res = 0;
        int imax = 0, dmax = 0;
        for (int num : nums) {
            res = Math.max(res, (long) dmax * num);
            dmax = Math.max(dmax, imax - num);
            imax = Math.max(imax, num);
        }
        return res;
    }
}