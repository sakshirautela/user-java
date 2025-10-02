import java.util.ArrayList;
import java.util.Arrays;

public class BalancedKFactorDecomposition {
    public static void main(String[] args) {
        int[] res = minDifference(44, 3);
        for (int i : res) {
            System.out.println(i);
        }
    }

    static int prev;
    static int[] finalres;

    public static int[] minDifference(int n, int k) {
        prev = Integer.MAX_VALUE;
        finalres = new int[k];

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                al.add(i);
            }
        }

        int[] res = new int[k];
        getKlargestFactor(al, n, al.size(), k, 0, res, 0, 1);
        return finalres;
    }

    private static void getKlargestFactor(ArrayList<Integer> al, int val, int n, int k,
                                          int i, int[] res, int idx, int mul) {
        if (mul > val) return;

        if (idx == k) {
            if (mul == val) {
                int[] sorted = res.clone();
                Arrays.sort(sorted);
                int diff = sorted[k - 1] - sorted[0];
                if (diff < prev) {
                    prev = diff;
                    finalres = sorted;
                }
            }
            return;
        }

        if (i == n) return;

        res[idx] = al.get(i);
        getKlargestFactor(al, val, n, k, i, res, idx + 1, mul * al.get(i));

        getKlargestFactor(al, val, n, k, i + 1, res, idx, mul);
    }
}
