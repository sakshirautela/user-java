public class RangeProductQueriesofPowers {
    public static void main(String[] args) {
        int[] res = productQueries(7, new int[][]{{0,1},{2,2},{0,3}});
        for (int i :res) {
            System.out.print(i+" ");
        }
    }

    public static int[] productQueries(int n, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        int mod= (int) (1e9+7);
        for (int k=0;k<len;k++){
            int[] range =queries[k];
            int result=1;
            for (int i = range[0]; i <=range[1]; i++) {
                result=(result*(2<<(i-1)))%mod;
            }
            res[k]=result;
        }
        return  res;
    }
}