package problemsolvingIII;

import java.util.ArrayList;
import java.util.List;

public class SeparatetheDigitsinanArray {
    static void main() {
        int[] r = separateDigitsFast(new int[]{});
        for (int i : r) {
            System.out.println(i);
        }
    }

    public static int[] separateDigitsFast(int[] arr) {
        int totalDigits = 0;
        for (int n : arr) {
            int temp = n;

            if (temp == 0) {
                totalDigits++;
            } else {
                while (temp > 0) {
                    totalDigits++;
                    temp /= 10;
                }
            }
        }
        int[] ans = new int[totalDigits];
        int index = totalDigits - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            if (num == 0) {
                ans[index--] = 0;
            } else {
                while (num > 0) {
                    ans[index--] = num % 10;
                    num /= 10;
                }
            }
        }
        return ans;
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            List<Integer> temp = new ArrayList<>();
            while (i > 0) {
                temp.addFirst(i % 10);
                i = i / 10;
            }
            list.addAll(temp);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
