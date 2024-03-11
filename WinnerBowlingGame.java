public class WinnerBowlingGame {
    public static void main(String[] args) {
        int res[]={ 10,4,0,2};
        int res2[]={ 5,10,8,0};
        System.out.println(isWinner(res, res2));
    }

    public static int isWinner(int[] player1, int[] player2) {
        int sum = 0;
        for (int i = 0; i < player1.length; i++) {
            
            if (i>=1 && (player1[i - 1] == 10 )){
                sum += (2 * player1[i]);
            }
            else if(i>=2 && player1[i - 2] == 10) {
                sum += (2 * player1[i]);
            }
            else{
                sum += player1[i];

            }


        }
        int sum2 = 0;
        for (int i = 0; i < player2.length; i++) {
            if (i >= 1 && (player2[i - 1] == 10)) {
                sum2 += (2 * player2[i]);
            }
            else if (i >= 2 && player2[i - 2] == 10) {
                sum2 += (2 * player2[i]);
            }
            else{
                sum2 += player2[i];

            }

        }
        if (sum > sum2) {
            return 1;
        } else if (sum < sum2) {
            return 2;
        } else {
            return 0;
        }
    }
}
