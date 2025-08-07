public class MaximumRectangleSum {
    public static void main(String[] args) {
        System.out.println(maxRectSum(new int[][]{}));
    }
    public static  int maxRectSum(int mat[][]) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int result=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                int sum=0;
                for (int start = i; start <n ; start++) {
                    for (int k = j; k < m; k++) {
                        sum+=mat[start][k];
                    }
                    result=Math.max(result,sum);
                }
            }
        }
        return result;
    }
}
