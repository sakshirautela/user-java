public class OptimalStrategyForAGame {
    static void main() {
        System.out.println(maximumAmount(new int[]{8, 15, 3, 7}));
    }

    public static int maximumAmount(int[] arr) {
        // code here
        int n = arr.length;
        maximumAmountUtil(n,arr, 0, n - 1, 0, true);
        return max;
    }

    static int max = 0;

    static void maximumAmountUtil(int n,int[] arr, int start, int end, int cost, boolean f) {
        if(start>=n || end<0){
            return;
        }
        if (start == end) {
            if (f) {
                cost += arr[start];
            }
            max = Math.max(cost, max);
            return;
        }
        if (f) {
            maximumAmountUtil(n,arr, start + 1, end, cost + arr[start], !f);
            maximumAmountUtil(n,arr, start, end - 1, cost + arr[end], !f);
        }
        maximumAmountUtil(n,arr, start + 1, end, cost, !f);
        maximumAmountUtil(n,arr, start + 1, end - 1, cost, !f);
    }
}
