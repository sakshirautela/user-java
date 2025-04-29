public class KthSmallestProductofTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(kthSmallestProduct(new int[]{},new int[]{},8));
    }
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // code here
        long low = 0, high = 1000000000;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessEqual(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private static long countLessEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                continue;
            }
            int low = 0, high = nums2.length - 1;
            while (low <= high) {
                int mid2 = low + (high - low) / 2;
                if ((long) nums1[i] * nums2[mid2] <= mid) {
                    count += mid2 + 1;
                    low = mid2 + 1;
                } else {
                    high = mid2 - 1;
                }
            }
        }
        return count;
    }
}
