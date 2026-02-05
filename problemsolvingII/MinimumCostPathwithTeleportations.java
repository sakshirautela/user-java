public class MinimumCostPathwithTeleportations {
    static void main() {
        System.out.println(minCost(new int[][]{{}}, 3));
    }

    public static int minCost(int[][] grid, int k) {
        int result = 0;
        minCostUtil(0,0,grid.length,grid[0].length,k,0,grid);
        return result;
    }

    private static int minCostUtil(int i, int j, int m, int n, int k, int cost, int[][] grid) {
//        if(i==m-1&&j==n-1){
//            return cost;
//        }
//        cost += grid[i][j];
//        for(int u=j+1;u<=n;u++){
//            for(int v=k+1;v<=m;v++){
//
//            }
//        }
//        minCostUtil(i+1,j,m,n,k,cost, grid);
//        minCostUtil(i,j+1,m,n,k,cost, grid);
        return 0;
    }
}
