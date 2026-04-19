package problemsolvingIII;

public class MaximumDistanceBetweenaPairofValues {
    static void main() {

    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                result = Math.max(result, j - i);
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

    public int maxDistance2(int[] nums1, int[] nums2) {
        int max = 0;

        int l2 = nums2.length;
        int l1 = nums1.length;

        int i = 0;
        int j = 0;

        while (i < l1 && j < l2) {
            if (nums1[i] <= nums2[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
                j++;
            }
        }

        return max;
    }
}