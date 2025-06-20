
public class WinnerteamGFG {
    public static int winnerTeam(int N, int[] X, int[] Y, int[] Z) {
        // Initialize indices
        int i = 0, j = 0, k = 0;

        // Loop until one of the arrays is fully traversed
        while (i < N || j < N || k < N) {
            if ( X[i] > Y[j] && X[i] > Z[k]) {
                if(j+1!=N){
                    j++;
                }
                if(j+1!=N){
                    j++;
                }
                k++;
            } else if (Y[j] > X[i] && Y[j] > Z[k]) {
                if(j+1!=N){
                    j++;
                }
                i++;
                k++;
            } else if (Z[k] > X[i] && Z[k] > Y[j]) {
                i++;
                j++;
            } else {
                i++;
                j++;
                k++;
            }
        }

        if (i == N) {
            return 0;  // X reached the end first
        }
        if (j == N) {
            return 1;  // Y reached the end first
        }
        return 2;      // Z reached the end first
    }

    public static void main(String[] args) {
        System.out.println(winnerTeam(3, new int[]{7, 5, 3}, new int[]{4, 8, 1}, new int[]{6, 2, 9}));
    }
}
