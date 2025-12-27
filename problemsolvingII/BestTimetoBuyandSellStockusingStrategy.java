public class BestTimetoBuyandSellStockusingStrategy {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{4, 7, 13}, new int[]{-1, -1, 0}, 2));
    }
        public long maxProfitFast(int[] prices, int[] strategy, int k) {
            long sum = 0;
            int kk = k / 2, n = prices.length;
            long current = 0, max = 0;
            for(int i = 0; i < kk; i++) {
                int val = prices[i] * strategy[i];
                sum += val;
                current += prices[i] - val;
            }
            for(int i = kk; i < k; i++) {
                int val = prices[i] * strategy[i];
                sum += val;
                current += prices[i] - val - prices[i - kk];
            }
            max = Math.max(max, current);
            for(int i = k; i < n; i++) {
                int val = prices[i] * strategy[i];
                sum += val;
                current += prices[i] - val - prices[i - kk] + prices[i - k] * strategy[i - k];
                max = Math.max(max, current);
            }
            return sum + max;
        }
    public static long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((long) prices[i] * strategy[i]);
        }
        long result = sum;
        int half = k / 2;
        result = Math.max(result, sum);
        for (int i = 0; i < k; i++) {
            if (i < half) {
                if (strategy[i] == 1) {
                    sum -= (long) prices[i];
                } else if (strategy[i] == -1) {
                    sum += (long) prices[i];
                }
            } else {
                if (strategy[i] == 0) {
                    sum += (long) prices[i];
                } else if (strategy[i] == -1) {
                    sum += 2 * (long) prices[i];
                }
            }
        }
        result = Math.max(result, sum);
        for (int i = k; i < n; i++) {
            int shift = (i + i + 1 - k) / 2;
            sum -= prices[shift];
            if (strategy[i - k] == -1) {
                sum -= prices[i - k];
            } else if (strategy[i - k] == 1) {
                sum += prices[i - k];
            }
            if (strategy[i] == 0) {
                sum += (long) prices[i];
            } else if (strategy[i] == -1) {
                sum += 2 * (long) prices[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}