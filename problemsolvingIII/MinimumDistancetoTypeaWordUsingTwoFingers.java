package problemsolvingIII;

import java.util.Arrays;

public class MinimumDistancetoTypeaWordUsingTwoFingers {
    static void main() {
        System.out.println(minimumDistance("HAPPY"));
    }

    public static int minimumDistance(String word) {
        int[] d1 = new int[]{-1, -1};
        int[] d2 = new int[]{-1, -1};
        int[][][][][] dp = new int[301][7][6][7][6];
        for (int[][][][] d : dp) {
            for (int[][][] x : d) {
                for (int[][] y : x) {
                    for (int[] z : y) {
                        Arrays.fill(z, -1);
                    }
                }
            }
        }
        return minimumDistanceUtil(word, 0, word.length(), d1, d2,dp);
    }

    public static int minimumDistanceUtil(String word, int i, int n, int[] f1, int[] f2, int[][][][][] dp) {
        if (i >= n) {
            return 0;
        }

        int[] p = getPoints(word.charAt(i));
        if (f1[0] == -1 && f2[0] == -1) {
            return minimumDistanceUtil(word, i + 1, n, p, f2, dp);
        }
        int d1 = Math.abs(f1[0] - p[0]) + Math.abs(f1[1] - p[1]);
        if (f2[0] == -1) {
            return Math.min(d1+minimumDistanceUtil(word, i + 1, n, p, f2, dp),
                    minimumDistanceUtil(word, i + 1, n, f1, p, dp));
        }
        if(dp[i][f1[0]][f1[1]][f2[0]][f2[1]]!=-1){
            return dp[i][f1[0]][f1[1]][f2[0]][f2[1]];
        }
        int d2 = Math.abs(f2[0] - p[0]) + Math.abs(f2[1] - p[1]);

        return dp[i][f1[0]][f1[1]][f2[0]][f2[1]]=Math.min(d1+minimumDistanceUtil(word, i + 1, n, p, f2, dp),
                d2+minimumDistanceUtil(word, i + 1, n, f1, p, dp));
    }

    private static void printDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int minimumDistanceDp(String word) {
        int[] d1 = new int[]{-1, -1};
        int[] d2 = new int[]{-1, -1};
        int[][][][][] dp = new int[301][7][6][7][6];
        for (int[][][][] d : dp) {
            for (int[][][] x : d) {
                for (int[][] y : x) {
                    for (int[] z : y) {
                        Arrays.fill(z, -1);
                    }
                }
            }
        }
        return minimumDistance2(word, 0, word.length(), d1, d2, dp);
    }

    public static int minimumDistance2(String word, int i, int n, int[] f1, int[] f2, int[][][][][] dp) {
        if (i >= n) {
            return 0;
        }

        int[] p = getPoints(word.charAt(i));

        if (f1[0] == -1) {
            return minimumDistance2(word, i + 1, n, p, f2, dp);
        }

        if (f2[0] == -1) {
            return minimumDistance2(word, i + 1, n, f1, p, dp);
        }

        if (dp[i][f1[0]][f1[1]][f2[0]][f2[1]] != -1) {
            return dp[i][f1[0]][f1[1]][f2[0]][f2[1]];
        }
        int d1 = Math.abs(f1[0] - p[0]) + Math.abs(f1[1] - p[1]);
        int d2 = Math.abs(f2[0] - p[0]) + Math.abs(f2[1] - p[1]);
        int useFinger1 = d1 + minimumDistance2(word, i + 1, n, p, f2, dp);
        int useFinger2 = d2 + minimumDistance2(word, i + 1, n, f1, p, dp);
        return dp[i][f1[0]][f1[1]][f2[0]][f2[1]] = Math.min(useFinger1, useFinger2);
    }

    private static int[] getPoints(char ch) {
        int c = (ch - 'A');
        int row = c / 6;
        int col = c % 6;
        return new int[]{row, col};
    }
}
