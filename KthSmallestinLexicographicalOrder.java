public class KthSmallestinLexicographicalOrder {
    public static int findKthNumber(int n, int k) {
        int currentNumber = 1;
        int result=0;
        for (int i = 0; i < n && k>0; ++i) {
            result=currentNumber;
            k--;
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10; // Remove the last digit
                }
                currentNumber += 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber(15,3));
    }
}