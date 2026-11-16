package problemsolvingIII;

public class MinimumCosttoAcquireRequiredItems {
    static void main() {

    }
    public static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 <= costBoth) {
            return (long) cost1 * need1 + (long) cost2 * need2;
        }
        long ans=0;
            int min = Math.min(need1, need2);
            ans = (long) min * costBoth;
            need1 -= min;
            need2 -= min;
            if (need1 > 0) {
                ans += (long) need1 * Math.min(cost1, costBoth);
            } else if (need2 > 0) {
                ans += (long) need2 * Math.min(cost2, costBoth);
            }
        return ans;
    }
}
