import java.util.*;
public class PridictorialNumber {
    static long countPeriodicalNumbers(long n) {
        if (n <= 0) return 0;

        long count = 0;
        for (int i = 1; i <= 63; i++) {
            for (int j = 0; j < i - 1; j++) {
                long num = (1L << i) - 1 - (1L << j);
                if (num <= n) {
                
                    count++;
                } else {
                    break;
                }
            }
        }


        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=1;
        for (int i = 0; i < n; i++){
            int r = 10;
            System.out.println(countPeriodicalNumbers(r));
        }
    }
}

