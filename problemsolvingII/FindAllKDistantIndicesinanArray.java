import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllKDistantIndicesinanArray {
    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[] {}, 3, 4));
    }

    static {
        for (int i = 0; i < 500; i++)
            findKDistantIndices(new int[] { 1, 1 }, 1, 1);
    }

    public static List<Integer> findKDistantIndicesFast(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length, i = 0, j = 0;

        while (i < n && j < n) {
            if (nums[j] != key)
                j++;
            else if (i < j - k)
                i++;
            else if (i <= j + k)
                res.add(i++);
            else
                j++;
        }

        return res;
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                for (int j = i; j < Math.min(n, i + k + 1); j++) {
                    hs.add(j);
                }
                for (int j = i; j >= Math.max(0, i - k); j--) {
                    hs.add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (hs.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}