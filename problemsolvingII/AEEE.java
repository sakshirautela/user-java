import java.util.HashSet;

public class AEEE {
    static void main() {
        //System.out.println(countVisiblePeople(3, 1, 0));
        System.out.println(minCostDP(new int[][]{{10,18,15},{26,16,13}}));
    }

    public static int minAbsoluteDifference(int[] nums) {
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] == 1 && nums[j] == 2) || (nums[i] == 2 && nums[j] == 1)) {
                    diff = Math.min(diff, Math.abs(i - j));
                }
            }
        }
        return (diff == Integer.MAX_VALUE) ? -1 : diff;
    }

    public static int countVisiblePeople(int n, int pos, int k) {
        return countPeople(n, 0, n - 1, pos, k);
    }

    public static int countPeople(int n, int l, int r, int pos, int k) {
        if (l == pos && r == pos) {
            return 2;
        }
        if (l == pos && r > pos) {

        }
        if (k < 0) {
            return 0;
        }
        int a = countPeople(n, l + 1, r, pos, k - 1);
        int b = countPeople(n, l + 1, r, pos, k);
        int c = countPeople(n, l, r - 1, pos, k);
        int d = countPeople(n, l, r - 1, pos, k - 1);
        return a + b + c + d;
    }

    public static int minCostDP(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int[][] dp2 = new int[n][m];
        dp[0][0] = grid[0][0];
        dp2[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] ^ grid[i][0];
            dp2[i][0] = dp2[i - 1][0] ^ grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] ^ grid[0][j];
            dp2[0][j] = dp2[0][j - 1] ^ grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) ^ grid[i][j];
                dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i][j - 1]) ^ grid[i][j];
            }
        }
        printDp(dp);
        System.out.println(33);
        printDp(dp2);


        return Math.min(dp[n - 1][m - 1],dp2[n-1][m-1]);
    }
        static final int MOD = 1_000_000_007;
        long[] fact, invFact;

        public int countVisiblePeopleBetter(int n, int pos, int k) {
            int left = pos;
            int right = n - pos - 1;
            init(n);

            long ans = 0;
            for (int x = 0; x <= k; x++) {
                if (x <= left && (k - x) <= right) {
                    long ways = nCr(left, x) * nCr(right, k - x) % MOD;
                    ans = (ans + ways) % MOD;
                }
            }
            ans = (ans * 2) % MOD;

            return (int) ans;
        }

        void init(int n) {
            fact = new long[n + 1];
            invFact = new long[n + 1];

            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = fact[i - 1] * i % MOD;
            }

            invFact[n] = modInverse(fact[n]);
            for (int i = n - 1; i >= 0; i--) {
                invFact[i] = invFact[i + 1] * (i + 1) % MOD;
            }
        }

        long nCr(int n, int r) {
            if (r < 0 || r > n) return 0;
            return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
        }

        long modInverse(long x) {
            return pow(x, MOD - 2);
        }

        long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) == 1) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    public static void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int minCost(int[][] grid) {
        min = Integer.MAX_VALUE;
        HashSet<String> visited = new HashSet<>();
        minCostDFS(grid, 0, 0, 0, visited);
        return min;
    }

    static int min;

    private static void minCostDFS(int[][] grid, int xor, int i, int j, HashSet<String> visited) {
        if (i > grid.length - 1 || j > grid[0].length - 1) {
            return;
        }

        xor = xor ^ grid[i][j];
        String key = xor + "|" + i + "|" + j;
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            min = Math.min(min, xor);
            return;
        }
        minCostDFS(grid, xor, i + 1, j, visited);
        minCostDFS(grid, xor, i, j + 1, visited);
    }
}
