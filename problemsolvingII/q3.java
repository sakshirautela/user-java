import java.util.Arrays;

public class q3 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2},new int[]{3,4}));
    }
        public static long minOperations(int[] nums1, int[] nums2) {
            int m = nums1.length;
            long op = 1;
            int add=nums2[m];
            for (int i = 0; i < m; i++) {
                int d = Math.abs(nums1[i] - nums2[i]);
                op += d;
                int min = Math.min(nums1[i], nums2[i]);
                int max = Math.max(nums1[i], nums2[i]);
                int gap = Math.min(Math.abs(min-add),Math.abs(max-add));
                add = Math.min(add, gap);
            }
            return op+add;
    }


}
