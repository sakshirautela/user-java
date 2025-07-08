import java.util.ArrayList;
import java.util.List;

public class FindtheOriginalTypedStringII {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("", 3));
    }

    static int mod = 1000000009;

    public static int possibleStringCount(String word, int k) {
        if (word == null || word.isEmpty() || k <= 0)
            return 0;
        List<Integer> freq = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                freq.add(count);
                count = 1;
            }
        }
        freq.add(count);

        long possible = 1;
        for (int num : freq) {
            possible = (possible * num) % mod;
        }
        if (k <= freq.size())
            return (int) possible;
        int[] dp = new int[k];
        dp[0] = 1;

        for (int num : freq) {
            int[] new_dp = new int[k];
            long sum = 0;
            for (int i = 0; i < k; i++) {
                if (i > 0)
                    sum = (sum + dp[i - 1]) % mod;
                if (i > num)
                    sum = (sum - dp[i - num - 1] + mod) % mod;
                new_dp[i] = (int) sum;
            }
            dp = new_dp;
        }

        long invalid = 0;
        for (int i = freq.size(); i < k; i++) {
            invalid = (invalid + dp[i]) % mod;
        }

        return (int) ((possible - invalid + mod) % mod);
    }
    public int possibleStringCountFast(String word, int k) {
        if(word.length()==k) return 1;
        List<Integer> list = new ArrayList<>();
        int n = word.length();
        int i = 0;
        while (i < n) {
            int j = i+1;
            while (j < n && word.charAt(j) == word.charAt(j-1)) j++;
            list.add(j - i);
            i = j;
        }
        int m = list.size();
        long[] power = new long[m];
        power[m-1] = list.get(m-1);
        for (i = m-2; i >= 0; i--) {
            power[i] = (power[i+1] * list.get(i)) % mod;
        }
        if (m >= k) return (int)power[0];
        long[][] dp = new long[m][k-m+1];
        for (i = 0; i < k-m+1; i++) {
            if (list.get(m-1) + i + m > k) dp[m-1][i] = list.get(m-1) - (k-m-i);
        }
        for (i = m-2; i >= 0; i--) {
            long sum = (dp[i+1][k-m] * list.get(i)) % mod;
            for (int j = k-m; j >= 0; j--) {
                sum += dp[i+1][j];
                if (j + list.get(i) > k-m) sum = (sum - dp[i+1][k-m] + mod) % mod;
                else sum = (sum - dp[i+1][j+list.get(i)] + mod) % mod;
                dp[i][j] = sum;
            }
        }
        return (int)dp[0][0];
    }
}