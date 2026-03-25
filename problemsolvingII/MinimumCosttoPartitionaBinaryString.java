public class MinimumCosttoPartitionaBinaryString {
    static void main() {
        System.out.println(minCost("1010", 2, 1));
    }

    public static long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int[] pre = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (s.charAt(i) - '0');
        }

        return minCostHeleper(encCost, flatCost, s, 0, pre, n - 1);
    }

    private static long minCostHeleper(int encCost, int flatCost, String s, int l,
                                       int[] pre, int r) {
        int size = r - l + 1;
        int o = pre[r + 1] - pre[l];

        long res=0;

        if (o == 0)
            res = flatCost;
        else
            res = (long) size * o * encCost;

        if (size % 2 == 0) {
            int mid = (l + r) / 2;
            res = Math.min(res, minCostHeleper(encCost, flatCost, s, l, pre, mid) + minCostHeleper(encCost, flatCost, s, mid + 1, pre, r));
        }

        return res;
    }
}