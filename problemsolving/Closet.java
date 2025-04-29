
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class Closet {
    public static void main(String args[]) {
        int[] nums = { -5, 5, 4, -3, 0, 0, 4, -2 };
        int target = 4;
        int n = nums.length;
        int temp = -10;

        List<List<Integer>> arr = new ArrayList();
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    for (int d = c + 1; d < nums.length; d++) {
                        int sum = nums[a] + nums[b] + nums[c] + nums[d];
                        if (sum == target) {
                            List<Integer> s = new ArrayList();
                            s.add(nums[a]);
                            s.add(nums[b]);
                            s.add(nums[c]);
                            s.add(nums[d]);
                            List<Integer> sortedList = s.stream().sorted().toList();

                            if (!arr.contains(sortedList)) {
                                arr.add(sortedList);

                            }

                        }
                    }

                }
            }
        }

        System.out.println(arr);
    }
}
