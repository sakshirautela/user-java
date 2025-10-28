import java.util.*;

public class NextGreaterNumericallyBalancedNumber {
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(5));
        System.out.println(nextBeautifulNumberFaster(5));
    }

    public static int nextBeautifulNumber(int n) {
        int result = 0;
        boolean found = false;
        while (!found) {
            HashMap<Integer, Integer> map = new HashMap<>();
            n++;
            int num = n;
            while (num > 0) {
                int rem = num % 10;
                map.put(rem, map.getOrDefault(rem, 0) + 1);
                num /= 10;
            }
            boolean a = false;
            for (int i : map.keySet()) {
                if (!(map.get(i) == i)) {
                    a = true;
                }
            }
            if (!a) {
                result = n;
                found = true;
            }
        }
        return result;
    }

    private static final int MAX_LEN = 7; // safe because n <= 1e6
    private static List<Integer> beautifulNumbers = null;

    public static  int nextBeautifulNumberFaster(int n) {
        if (beautifulNumbers == null) buildBeautifulNumbers();
        // find the smallest number > n
        for (int val : beautifulNumbers) {
            if (val > n) return val;
        }
        // As a fallback (shouldn't happen for constraints), return -1
        return -1;
    }

    private static void buildBeautifulNumbers() {
        Set<Integer> set = new HashSet<>();
        int[] counts = new int[10]; // counts[d] = d or 0
        backtrack(1, 0, counts, set);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        beautifulNumbers = list;
    }

    // choose for digit d either include d copies or skip
    private static void backtrack(int d, int totalLen, int[] counts, Set<Integer> set) {
        if (d == 10) {
            if (totalLen == 0) return;
            // build char array of digits according to counts and permute
            char[] arr = new char[totalLen];
            int idx = 0;
            for (int dig = 1; dig <= 9; ++dig) {
                for (int k = 0; k < counts[dig]; ++k) {
                    arr[idx++] = (char) ('0' + dig);
                }
            }
            Arrays.sort(arr);
            // generate unique permutations
            do {
                // leading char won't be '0' because digits are 1..9
                int val = 0;
                for (char c : arr) {
                    val = val * 10 + (c - '0');
                }
                set.add(val);
            } while (nextPermutation(arr));
            return;
        }

        // option 1: skip digit d
        backtrack(d + 1, totalLen, counts, set);

        // option 2: include digit d (d occurrences) if fits length limit
        if (totalLen + d <= MAX_LEN) {
            counts[d] = d;
            backtrack(d + 1, totalLen + d, counts, set);
            counts[d] = 0;
        }
    }

    // standard next_permutation for char array (lexicographic)
    private static boolean nextPermutation(char[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = a.length - 1;
        while (a[j] <= a[i]) j--;
        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    private static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void reverse(char[] a, int i, int j) {
        while (i < j) swap(a, i++, j--);
    }
    public int nextBeautifulNumberMyUpgrade(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBalance(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }
}