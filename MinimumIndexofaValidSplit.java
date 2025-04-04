import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexofaValidSplit {
    public static void main(String[] args) {
        
    }

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int n = nums.size();
        for (int num : nums) {
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index < n; index++) {
            int num = nums.get(index);
            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            if (firstMap.get(num) * 2 > index + 1 &&
                    secondMap.get(num) * 2 > n - index - 1) {
                return index;
            }
        }

        return -1;
    }

    public int minimumIndex2(List<Integer> nums) {
        int n = nums.size();
        int dominant = -1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                dominant = nums.get(i);
                cnt++;
            } else if (nums.get(i) == dominant) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int maxC = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                maxC++;
            }
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                c++;
            }
            if (c * 2 > (i + 1) && (maxC - c) * 2 > (n - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}