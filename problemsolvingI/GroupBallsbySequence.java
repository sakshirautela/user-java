import java.util.Arrays;
import java.util.TreeMap;

public class GroupBallsbySequence {
    public static boolean validgroup2(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i += k) {
            for (int j = i + 1; j < Math.min(n, i + k); j++) {
                if (arr[j] != arr[j - 1] + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean validgroup(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (var p : map.entrySet()) {
            int val = p.getKey(), freq = p.getValue();
            if (freq == 0)
                continue;
            for (int i = 1; i < k; i++) {
                int v = val + i;
                int f = map.getOrDefault(v, 0);
                if (f < freq) {
                    return false;
                }

                map.put(v, f - freq);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 11 };
        int k = 3;
        if (validgroup(arr, k)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}