package problemsolvingIII;

public class a {
    static void main() {
        System.out.println(minOperations(new int[]{8,12}));
        System.out.println(isPrime(9));
    }

    public static String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        if (timer == 30) return "Orange";
        if (30 < timer && timer <= 90) return "Red";
        return "Invalid";
    }

    public static int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for (int num : nums) {
            while (num > 0) {
                count += (num % 10 == 2 ? 1 : 0);
                num /= 10;
            }
        }
        return count;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int evenPrime = 0;
        for (int k = 0; k < n; k++) {
            boolean prime = isPrime(nums[k]);
            if (k % 2 == 0 && !prime) {
                evenPrime += closetPrimeNumber(nums[k]);

            } else if (k % 2 == 1 && prime) {
                if (nums[k] == 2) {
                    evenPrime += 2;
                } else {
                    evenPrime++;
                }
            }
        }
        return evenPrime;
    }

    private static int closetPrimeNumber(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;
        int d = ((num % 2 == 0) ? 1 : 2);
        int right = num + d;
        int count = d;
        while (!isPrime(right)) {
            right += 2;
            count += 2;
        }
        return count;
    }


    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}