package problemsolvingIII;

import java.util.Arrays;

public class NotaSubSetSum {
    static void main() {
        System.out.println(findSmallest(new int[]{1, 2, 3}));
    }

    public static int findSmallestOlogN(int[] arr) {
        Arrays.sort(arr);
        int res=1;
        for(int i=0;i<arr.length && arr[i]<=res;i++) {
            res+=arr[i];
        }
        return res;
    }
        public static int findSmallest(int[] arr) {
        // code here
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int i = sum - num; i >= 0; i--) {
                if (dp[i]) {
                    dp[i + num] = true;
                }
            }
        }
        for(int i = 1; i <= sum; i++){
            if(!dp[i]){
                return i;
            }
        }
        return sum+1;
    }
}
