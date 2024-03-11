import java.io.*;
import java.util.*;

public class CandidateCode {
    public static void main(String args[]) throws Exception {
        int[] array = { -1, 0, -2, -1 };
        int sum = 0;
        int op = 0;
        int minNeg = Integer.MAX_VALUE;

        for (int i : array) {
            if (i < 0) {
                op++;
                i = -i;
                minNeg = Math.min(minNeg, Math.abs(i));
            }
            sum += i;
        }

        if (op % 2 == 0) {
            op = 0;
        } else {
            sum -= 2 * minNeg;
            op = 1;
        }
        System.out.print(sum + " " + op);
    }
}
