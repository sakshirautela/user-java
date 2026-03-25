public class CountSubmatricesWithEqualFrequencyofXandY {
    static void main() {
        System.out.println(numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] count = new int[m][n][2];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') {
                    count[i][j][0]++;
                } else if (grid[i][j] == 'Y') {
                    count[i][j][1]++;
                }
                if (i != 0 ) {
                    count[i][j][0] += count[i-1][j][0];
                    count[i][j][1] += count[i-1][j][1];
                }
                if (j != 0 ) {
                    count[i][j][0] += count[i][j-1][0];
                    count[i][j][1] += count[i][j-1][1];
                }
                if(i>0 && j>0){
                    count[i][j][1] -= count[i-1][j-1][1];
                    count[i][j][0] -= count[i-1][j-1][0];
                }
                if(count[i][j][0]==count[i][j][1]){
                    res++;
                }
            }
        }
        return res;
    }
    public int numberOfSubmatrices2(char[][] grid) {
        int[] countX = new int[grid[0].length];
        int[] countY = new int[grid[0].length];
        int answer = 0;
        for(int i = 0; i < grid.length; i++) {
            int x = 0;
            int y = 0;
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 'X') x++;
                if(grid[i][j] == 'Y') y++;
                countX[j] += x;
                countY[j] += y;
                if(countX[j] >= 1 && countX[j] == countY[j]) answer++;
            }
        }
        return answer;
    }
    public int numberOfSubmatrices3(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] colX = new int[n];
        int[] colY = new int[n];
        int ans = 0;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 'X') colX[j]++;
                if(grid[i][j] == 'Y') colY[j]++;
            }

            int x = 0, y = 0;
            for(int j = 0; j < n; j++) {

                x += colX[j];
                y += colY[j];

                if(x == y && x > 0) ans++;
            }
        }

        return ans;
    }
}
