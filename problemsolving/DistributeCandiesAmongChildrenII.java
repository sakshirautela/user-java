public class DistributeCandiesAmongChildrenII {
    public static void main(String[] args) {
        System.out.println(distributeCandies(3, 3));
    }

    public static long distributeCandiesTLE(int n, int limit) {
        long ways = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            for (int j = 0; j <= limit; j++) {
                int third = n - i - j;
                System.out.println(i + " " + j + " " + third);
                if (third >= 0 && i + j + third <= n && third <= limit) {
                    ways++;
                }
            }
        }
        return ways;
    }
    public long distributeCandiesFast(int n, int limit) {
          return totalWays(n)- 3 * totalWays(n - (limit + 1))+ 3 * totalWays(n - 2 * (limit + 1))- totalWays(n - 3 * (limit + 1));
    }
    private long totalWays(long sum) {
        if (sum < 0) return 0;
        return (sum + 2) * (sum + 1) / 2;
    }
    public static long distributeCandies(int n, int limit) {
        long ways = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if(n-i>2*limit){
                continue;
            }
        ways+=Math.min(n-i,limit)-Math.max(n-i-limit,0)+1;
        }
        return ways;
    }
}