import java.util.List;
import java.util.ArrayList;

class TriangleSum {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n+1];
        for(int i=triangle.size()-1;i>=0; i--){
            for (int j =0 ;j<= triangle.get(i).size()-1;j++) {
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
            for (int j = 0; j <=n; j++) {
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[][] list={{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> dp = new ArrayList<>();
        for (int[] row : list) {
            List<Integer> rowList = new ArrayList<>();
            for (int value : row) {
                rowList.add(value);
            }
            dp.add(rowList);
        }
        System.out.println(dp);
        System.out.println(minimumTotal(dp));
    }
}