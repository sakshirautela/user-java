public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][] { {} }));
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = i + questions[i][1] + 1;
            if (idx >= n) {
                dp[i] = questions[i][0];
            } else {
                dp[i] = dp[idx] + questions[i][0];
            }
            if (i < n - 1) {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }


    public static long mostPoints3(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        // Arrays.fill(dp, -1);
        // return calcMaxPoints(questions, 0, n, dp);
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            long take = questions[i][0];
            int newIndex = i + questions[i][1] + 1;
            take += (newIndex < n) ? dp[newIndex] : 0;
            long notTake = dp[i + 1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }
}