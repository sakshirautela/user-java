public class EqualSumGridPartition {
    static void main() {
        System.out.println(canPartitionGrid(new int[][]{{2,1,1},{3,1,2}}));
    }

    public static  boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
            }
        }
        if (sum % 2 == 1) return false;
        long target = sum / 2;
        long s=0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                s += grid[i][j];
            }
            if(s==target) return true;
        }
        s=0;
        for (int j=0;j<m;j++){
            for (int i = 0; i <n ; i++) {
                s += grid[i][j];
            }
            System.out.println(s);
            if(s==target) return true;
        }
        return false;
    }
}
