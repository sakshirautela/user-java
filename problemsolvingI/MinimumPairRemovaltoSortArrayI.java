import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemovaltoSortArrayI {

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5,2,3,1}));
//        System.out.println(minimumPairRemoval(new int[]{1, 3, 2, 3, 1}));
//        System.out.println(minimumPairRemoval(new int[]{1, 2, 3, 4, 5}));
    }

    public static int minimumPairRemoval(int[] nums) {
            List<Integer> li = new ArrayList<>();
            for (int num : nums) {
                li.add(num);
            }
            var count = 0;

            while (li.size() > 1) {
                var isAscending = true;
                var minSum = Integer.MAX_VALUE;
                var targetIndex = -1;

                for (var i = 0; i < li.size() - 1; i++) {
                    var sum = li.get(i) + li.get(i + 1);

                    if (li.get(i) > li.get(i + 1)) {
                        isAscending = false;
                    }

                    if (sum < minSum) {
                        minSum = sum;
                        targetIndex = i;
                    }
                }

                if (isAscending) {
                    break;
                }

                count++;
                li.set(targetIndex, minSum);
                li.remove(targetIndex + 1);
            }

            return count;
        }
}
