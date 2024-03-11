public class SmoothDescentPeriodsStock {
    public static long getDescentPeriods(int[] prices) {
        long result = 1;
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                result += i - count + 1;
            } else {
                count = i;
                result += i - count + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] price={1};
        System.out.println(getDescentPeriods(price));
    }
}
