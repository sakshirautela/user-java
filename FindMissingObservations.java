public class FindMissingObservations {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sumObserved = 0;
        for (int i : rolls) {
            sumObserved += i;
        }

        // Total sum we need for all rolls
        int totalSum = mean * (n + rolls.length);
        // Sum required from the missing rolls
        int sumMissing = totalSum - sumObserved;

        // If the sumMissing is out of possible bounds (n * 1 to n * 6), no solution is
        // possible
        if (sumMissing < n || sumMissing > 6 * n) {
            return new int[0];
        }

        int[] res = new int[n];
        // Distribute sumMissing across n rolls
        int quotient = sumMissing / n;
        int remainder = sumMissing % n;

        // Assign values ensuring they are between 1 and 6
        for (int i = 0; i < n; i++) {
            res[i] = quotient + (i < remainder ? 1 : 0);
        }

        return res;
    }



        public int[] missingRolls2(int[] rolls, int mean, int n) {
            int[] ret = new int[n];
            int sum = 0;
            for (int i : rolls) {
                sum += i;
            }
            int missingSum = mean * (n + rolls.length) - sum;
            if (missingSum > 6*n ){//|| missingSum < n) {
                return new int[]{};
            }
            int expectedAvg = missingSum/n, remainder = missingSum%n;
    
            for (int i = 0; i < remainder; i++) {
                ret[i] = expectedAvg + 1;
            }
            for (int i = remainder; i < n;i++) {
                ret[i] = expectedAvg;
            }
            return ret;
        }
    public static void main(String args[]) {
        int[] res = missingRolls(new int[] { 3, 2, 4, 3 }, 4, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
