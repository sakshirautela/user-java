import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeAdjucentEqualElements {
    static void main() {
        System.out.println(mergeAdjacent(new int[]{2,1,1,2}));
    }

    public static List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        List<Long> list = new ArrayList<Long>();
        list.add((long) nums[0]);
        for (int i = 1; i < n; i++) {
            long num=nums[i];
            long add=nums[i];
            while (!list.isEmpty() && list.getLast() == num) {
                list.removeLast();
                num*=2;
                add=num;
            }
            list.add(add);
        }
        return list;
    }
}