public class GridGame {
    public static void main(String[] args) {
        System.out.println(gridGame(new int[][] { { 2, 5, 4 }, { 1, 5, 1 } }));
    }

    public static long gridGame(int[][] grid) {
        long min=Long.MAX_VALUE;
        long first=0;
        for(int i:grid[0]){
            first+=i;
        }
        long second=0;
        for(int i=0;i<grid[0].length;i++){
            first-=grid[0][i];
            min=Math.min(min,Math.max(first,second));
            second+=grid[1][i];
        }
        return min;
    }
}