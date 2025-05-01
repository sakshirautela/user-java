public class FindNumberswithEvenNumberofDigits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] {}));
    }

    public static int findNumbers(int[] nums) {
        int n = 0;
        for (int i : nums) {
            int a = 0;
            while (i > 0) {
                a++;
                i = i / 10;
            }
            if (a % 2 == 0) {
                n++;
            }
        }
        return n;
    }

    public int findNumbers2(int[] nums) {
        int result = 0;
        for (int number : nums) {
            if ((number > 9 && number < 100) || (number > 999 && number < 10000) || (number == 100000))
                result++;
        }
        return result;
    }
}