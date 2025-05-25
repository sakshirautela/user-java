public class FindtheMinimumAreatoCoverAllOnesI {
    public static void main(String[] args) {
        System.err.println(minimumArea(new int[][]{{0,1,0},{1,0,1}}));
    }
    public  static int minimumArea(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int starti=-1,endi=-1;
        int startj=m,endj=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(starti==-1){
                        starti=i;
                    }
                    endi=i;
                }
                 if(grid[i][j]==1 ){
                    startj=Math.min(startj, j);
                }
                if(grid[i][j]==1 ){
                    endj=Math.max(endj, j);
                }
            }
        }
        System.out.println(starti+" "+endi+" "+startj+" "+endj);
        return (endj-startj+1)*(endi-starti+1);
    }
    public int minimumArea2(int[][] grid) {
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int n = grid.length;
        int m = grid[0].length;

        // Top
        for (int i = 0; i < n; i++) {
            boolean is = false;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    is = true;
                    break;
                }
            }
            if (!is) top++;
            else break; // fix: break when you find first row with 1
        }

        // Bottom
        for (int i = n - 1; i >= 0; i--) {
            boolean is = false;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    is = true;
                    break;
                }
            }
            if (!is) bottom++;
            else break; // fix: break when you find last row with 1
        }

        // Left
        for (int i = 0; i < m; i++) {
            boolean is = false;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) { // fix: swap grid[i][j] to grid[j][i]
                    is = true;
                    break;
                }
            }
            if (!is) left++;
            else break; // fix: break when you find first column with 1
        }

        // Right
        for (int i = m - 1; i >= 0; i--) {
            boolean is = false;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) { // fix: swap grid[i][j] to grid[j][i]
                    is = true;
                    break;
                }
            }
            if (!is) right++;
            else break; // fix: break when you find last column with 1
        }

        if (top == n) {
            // No 1's found in the grid
            return 0;
        }

        return (n - bottom - top) * (m - left - right);
    }
}