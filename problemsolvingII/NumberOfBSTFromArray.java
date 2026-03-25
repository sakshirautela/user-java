import java.util.*;

public class NumberOfBSTFromArray {

    static void main() {
        System.out.println(countBSTs(new int[]{1, 2, 3}));
    }

    public static ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        TreeMap<Integer, Integer> mapper = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long count = catalan(i) * catalan(n - i - 1);
            mapper.put(map.get(arr[i]), (int) count);
        }
        return new ArrayList<>(mapper.values());
    }

    static long catalan(int n) {
        return nCr(2 * n, n) / (n + 1);
    }

    static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static long nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
}