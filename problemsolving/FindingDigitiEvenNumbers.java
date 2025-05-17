import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindingDigitiEvenNumbers {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 0 };
        for (int i : arr) {
            System.out.println(i + " ");
        }
        System.out.println("aafter");
        int[] res = findEvenNumbers(arr);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }
     int ans[] = new int[451];

    public int[] findEvenNumbers2(int[] digits) {
        int count[] = new int[10];
        int size = 0;
        for (int d : digits)
            count[d]++;

        for (int i = 1; i < 10; i++) {
            if (count[i] == 0)
                continue;
            --count[i];
            for (int j = 0; j < 10; j++) {
                if (count[j] == 0)
                    continue;
                --count[j];
                for (int k = 0; k < 10; k += 2) {
                    if (count[k] == 0)
                        continue;
                    int num = i * 100 + j * 10 + k;
                    ans[size++] = num;
                }
                ++count[j];
            }
            ++count[i];
        }
        return Arrays.copyOf(ans, size);
    }
}