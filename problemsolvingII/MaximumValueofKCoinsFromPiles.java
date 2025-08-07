import java.util.List;

public class MaximumValueofKCoinsFromPiles {
    public static void main(String[] args) {
        System.out.println(maxValueOfCoins(
                List.of(List.of(1,100,3), List.of(4, 5), List.of(7,8,9)),
                2));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n +1][k +1];
        int len[] = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = piles.get(i).size();
        }
        maxValueOfCoinsUtil(piles, k, n, 0, 0,0, len, dp);
        print(dp);
        return dp[n][k];
    }

    private static void print(int[][] dp) {
        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static int maxValueOfCoinsUtil(List<List<Integer>> piles, int k, int n, int i, int j,int chance, int[] len,
            int[][] dp) {
        if (i == n) {
            return 0;
        }
        if(k==chance+1){
            return 0;
        }
        if (j == len[i]) {
            return maxValueOfCoinsUtil(piles, k, n, i + 1, 0,chance, len, dp);
        }
        int res= 0;
        for(int idx=0;idx<=Math.min(j,len[j]-1);idx++){
           res=Math.max( maxValueOfCoinsUtil(piles, k, n, i, j + 1,chance+1, len, dp)+ piles.get(i).get(idx), res);
           res=Math.max( maxValueOfCoinsUtil(piles, k, n, i, j + 1,chance, len, dp), res);
        }
        res=Math.max(maxValueOfCoinsUtil(piles, k, n, i + 1, 0,chance+1, len, dp), + piles.get(i).get(j));
        return dp[i][j] = Math.max(res,Math.max(maxValueOfCoinsUtil(piles, k, n, i, j+1,chance, len, dp),maxValueOfCoinsUtil(piles, k, n, i+1, j, chance,len, dp)));
    }
}