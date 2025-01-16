import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairclosesttotarget {
    public static void main(String[] args) {
        System.out.println(sumClosest(new int[] { 5, 2, 7, 1, 4 }, 10));
    }

    public static List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int n=arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];
            if (Math.abs(target - currSum) < minDiff) {
                minDiff = Math.abs(target - currSum);
                res = Arrays.asList(arr[left], arr[right]);
            }
            if (currSum < target)
                left++;
            else if (currSum > target)
                right--;
            else
                return res;
        }

        return res;
    }
}