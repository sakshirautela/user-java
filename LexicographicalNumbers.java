import java.util.List;
import java.util.ArrayList;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(15));
    }

    public static  List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        int currentNumber = 1;

        // Generate numbers from 1 to n
        for (int i = 0; i < n; ++i) {
            lexicographicalNumbers.add(currentNumber);

            // If multiplying the current number by 10 is within the limit, do it
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                // Adjust the current number by moving up one digit
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10; // Remove the last digit
                }
                currentNumber += 1; // Increment the number
            }
        }

        return lexicographicalNumbers;
    }

    public List<Integer> output = new ArrayList<>();

    public List<Integer> lexicalOrder1(int n) {
        recursiveTrie(0, n);
        return output;
    }

    public void recursiveTrie(int node, int n) {
        for (int i = node; i <= Math.min(node + 9, n); i++) {
            if (i == 0)
                continue;
            output.add(i);
            if (10 * i <= n)
                recursiveTrie(10 * i, n);
        }
    }
}
