import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaximumProductofTwoIntegersWithNoCommonBits {
    public static void main(String[] args) {
        System.out.println(3 | 4);
        System.out.println(maxProduct(new int[]{3,3,3,4}));
    }

    public static long maxProduct(int[] nums) {
        HashMap<Integer, Integer> maxForMask = new HashMap<>();
        for (int num : nums) {
            maxForMask.put(num, Math.max(maxForMask.getOrDefault(num, 0), num));
        }

        ArrayList<Integer> masks = new ArrayList<>(maxForMask.keySet());
        int size=masks.size();
        System.out.println(maxForMask);
        System.out.println(size);
        long maxProduct = 0;
//        for (int i = size-1; i >=0;i--) {
//            for (int j = i - 1; j >=0;j--) {
//                int mask1 = masks.get(i), mask2 = masks.get(j);
//                if ((mask1 & mask2) == 0) {
//                    return (long) maxForMask.get(mask1) * maxForMask.get(mask2);
//                }
//            }
//        }

        return maxProduct;
    }
}