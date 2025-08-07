import java.util.HashSet;
import java.util.Set;

public class BitwiseOrOfSubarray {
    public static int subArrayBitwiseOrs(int[] arr) {

        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> cur = new HashSet<>();
        for (int num : arr) {
            HashSet<Integer> next = new HashSet<>();
            next.add(num);
            for (int x : cur) {
                next.add(x | num);
            }
            cur = next;
            res.addAll(cur);
        }
        return res.size();
    }

    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] == (arr[j] | arr[i])) break;
                arr[j] |= arr[i];
                result.add(arr[j]);
            }
        }
        return result.size();
    }
}
