public class DetonatetheMaximumBombs {
    public static void main(String[] args) {
        System.err.println(maximumDetonation(new int[][] {
    {54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3},
    {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2},
    {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2},
    {20, 97, 8}, {35, 37, 3}}));
    }
    public static int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        int detonate=0;
        for (int i = 0; i <n; i++) {
            int bomb=1;
            for (int j = i+1; j < n; j++) {
                double d=Math.sqrt(Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2));
                int r=bombs[i][2]+bombs[j][2];
                if(d<=r){
                    System.out.println(d+" , "+r+" , "+i+" , "+j);
                    bomb++;
                }
            }
            detonate=Math.max(detonate,bomb);
        }
        return detonate;
    }
}