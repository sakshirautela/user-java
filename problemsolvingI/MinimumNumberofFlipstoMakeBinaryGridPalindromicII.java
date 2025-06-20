public class MinimumNumberofFlipstoMakeBinaryGridPalindromicII {
    public static void main(String[] args) {
        System.out.println(minFlips(new int[][]{{}}));
    }
    public static int minFlips(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int margin=n/2;
        int result=0;
        for (int i = 0; i < m; i++) {
            int sum1=0,sum2=0;
            for (int j = 0; j <= margin; j++) {
                sum1+=grid[i][j];
                sum2+=grid[i][margin+1];
            }
            result+=Math.abs(sum1-sum2);
        }
        return result;
    }
}