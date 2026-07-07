package problemsolvingIII;

public class MaxProductSubset {
    static void main() {
        System.out.println(findMaxProduct(new int[]{1, 2, 3}));
    }

    public static int findMaxProductConstent(int[] arr) {
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        int mod = (int)1e9 + 7;
        int zero = 0;
        int neg = 0;
        long product = 1;
        int least = Integer.MIN_VALUE;
        int leastIdx=-1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zero++;
            } else {
                if (arr[i] < 0) {
                    if(least<arr[i]){
                        least = arr[i];
                        leastIdx = i;
                    }
                    neg++;
                }
            }
        }
        if(zero==n){
            return 0;
        }
        if(neg==1 && zero==n-1){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                continue;
            }
            if(neg%2!=0 && i==leastIdx){
                continue;
            }
            product=((arr[i]*product)%mod+mod)%mod;
        }
        return Math.toIntExact(product);
    }

    public static int findMaxProduct(int[] arr) {
        // code here
        int n = arr.length;
        long[] ans = {Long.MIN_VALUE};
        int[] dp = new int[n];
        findMaxProductHelper(arr, 0, n, 1, false, ans);
        return (int) ans[0];
    }

    private static void findMaxProductHelper(int[] arr, int i, int n, int p, boolean b, long[] ans) {
        if (i == n) {
            if (b) {
                ans[0] = Math.max(ans[0], p);
            }
            return;
        }
        findMaxProductHelper(arr, i + 1, n, p, b, ans);
        findMaxProductHelper(arr, i + 1, n, p * arr[i], true, ans);
    }
}
