package problemsolvingIII;

public class MinimumInsertandDeletetoConvert {
    static void main() {
        System.out.println(minInsAndDel(new int[]{1, 2, 5, 3, 1},new int[]{1, 3, 5}));
    }
    public static int minInsAndDel(int[] b, int[] a) {
        // code here
            int n=a.length;
            int m=b.length;
            int[][] dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                dp[i][0]=i;
            }
            for(int j=0;j<=m;j++){
                dp[0][j]=j;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(a[i-1]!=b[j-1]){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }else{
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
            }
            printDP(dp);
            int lcs=dp[n][m];
            int delete=n-lcs;
            int insert=m-lcs;
            return delete+insert;
    }
    static void printDP(int[][] dp){
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
