import java.util.Arrays;
import java.util.HashSet;

public class CountNumberofBalancedPermutations {
    public static void main(String[] args) {
        System.out.println(countBalancedPermutations("12345"));
    }
    private static final int MOD = 1_000_000_007;
    private static final int MAX_SIZE = 41;
    private static final long[] factorials = new long[MAX_SIZE];
    private static final long[] inverseFactorials = new long[MAX_SIZE];
    
    // Static initialization of factorials and inverse factorials
    static {
        initializeFactorials();
        initializeInverseFactorials();
    }
    
    private static void initializeFactorials() {
        factorials[0] = 1;
        for (int i = 1; i < MAX_SIZE; i++) {
            factorials[i] = factorials[i - 1] * i % MOD;
        }
    }
    
    private static void initializeInverseFactorials() {
        inverseFactorials[MAX_SIZE - 1] = modularPow(factorials[MAX_SIZE - 1], MOD - 2);
        for (int i = MAX_SIZE - 1; i > 0; i--) {
            inverseFactorials[i - 1] = inverseFactorials[i] * i % MOD;
        }
    }
    
    public int countBalancedPermutations4(String num) {
        int[] digitCounts = calculateDigitCounts(num);
        int totalSum = calculateTotalSum(num);
        
        // Early return if total sum is odd
        if (totalSum % 2 != 0) {
            return 0;
        }
        
        // Convert to prefix sum array
        for (int i = 1; i < 10; i++) {
            digitCounts[i] += digitCounts[i - 1];
        }
        
        int length = num.length();
        int halfLength = length / 2;
        
        // Initialize memoization array
        int[][][] memo = initializeMemoArray(halfLength, totalSum);
        
        // Calculate final result using recursion
        return (int) (factorials[halfLength] * 
                     factorials[length - halfLength] % MOD * 
                     recursiveBalance(9, halfLength, totalSum / 2, digitCounts, memo) % MOD);
    }
    
    private int[] calculateDigitCounts(String num) {
        int[] counts = new int[10];
        for (char c : num.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }
    
    private int calculateTotalSum(String num) {
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
    
    private int[][][] initializeMemoArray(int halfLength, int totalSum) {
        int[][][] memo = new int[10][halfLength + 1][totalSum / 2 + 1];
        for (int[][] matrix : memo) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return memo;
    }
    
    private int recursiveBalance(int digit, int remainingLeft, int remainingSum, 
                               int[] digitCounts, int[][][] memo) {
        // Base case
        if (digit < 0) {
            return remainingSum == 0 ? 1 : 0;
        }
        
        // Check memoization
        if (memo[digit][remainingLeft][remainingSum] != -1) {
            return memo[digit][remainingLeft][remainingSum];
        }
        
        long result = 0;
        int currentCount = digitCounts[digit] - (digit > 0 ? digitCounts[digit - 1] : 0);
        int remainingRight = digitCounts[digit] - remainingLeft;
        
        // Try different distributions of the current digit
        for (int k = Math.max(currentCount - remainingRight, 0); 
             k <= Math.min(currentCount, remainingLeft) && k * digit <= remainingSum; 
             k++) {
            long subResult = recursiveBalance(digit - 1, 
                                           remainingLeft - k, 
                                           remainingSum - k * digit, 
                                           digitCounts, 
                                           memo);
            result = (result + subResult * inverseFactorials[k] % MOD * 
                     inverseFactorials[currentCount - k]) % MOD;
        }
        
        memo[digit][remainingLeft][remainingSum] = (int) result;
        return (int) result;
    }
    
    private static long modularPow(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exponent /= 2;
        }
        return result;
    }
    public static int countBalancedPermutations(String num) {
        HashSet<String> uniqe = new HashSet<>();
        int n = num.length();
        int[] arr = new int[n];
        int sum = 0;
        if (sum % 2 != 0) {
            return 0;
        }
        int[] s = { sum / 2, sum / 2 };
        for (int i = 0; i < n; i++) {
            arr[i] = num.charAt(i) - '0';
            sum += arr[i];
        }
        return premute(arr, 0, n, uniqe, s);
    }

    private static int premute(int[] arr, int idx, int n, HashSet<String> uniqe, int[] sum) {
        if (idx == n) {
            String s = Arrays.toString(arr);
            if (!uniqe.contains(s)) {
                uniqe.add(s);
                if ((sum[0] == sum[1])) {
                    return 1;
                }
            }
            return 0;
        }
        int res = 0;
        for (int i = idx; i < n; i++) {
            swap(arr, i, idx, sum);
            res += premute(arr, idx + 1, n, uniqe, sum);
            swap(arr, i, idx, sum);
        }
        return res;
    }

    private static void swap(int[] arr, int i, int idx, int[] sum) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }

    private static final int mod = 1_000_000_007;
    private long[] fact, inv, invFact;

    private void precompute(int n) {
        fact = new long[n + 1];
        inv = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = inv[0] = invFact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i % mod;
        inv[1] = 1;
        for (int i = 2; i <= n; i++)
            inv[i] = mod - (mod / i) * inv[mod % i] % mod;
        for (int i = 1; i <= n; i++)
            invFact[i] = invFact[i - 1] * inv[i] % mod;
    }

    public int countBalancedPermutations2(String num) {
        int n = num.length(), sum = 0;
        for (char c : num.toCharArray())
            sum += c - '0';
        if ((sum & 1) == 1)
            return 0;
        precompute(n);
        int halfSum = sum / 2, halfLen = n / 2;
        int[][] dp = new int[halfSum + 1][halfLen + 1];
        dp[0][0] = 1;
        int[] digits = new int[10];
        for (char c : num.toCharArray()) {
            int d = c - '0';
            digits[d]++;
            for (int i = halfSum; i >= d; i--)
                for (int j = halfLen; j > 0; j--)
                    dp[i][j] = (dp[i][j] + dp[i - d][j - 1]) % mod;
        }
        long res = dp[halfSum][halfLen];
        res = res * fact[halfLen] % mod * fact[n - halfLen] % mod;
        for (int cnt : digits)
            res = res * invFact[cnt] % mod;
        return (int) res;
    }
}