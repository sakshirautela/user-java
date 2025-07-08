import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumofSubarrayMinimums {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[] { 3, 1, 2,4}));
    }

    public static int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            System.out.println(stack);
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < right.length; i++) {
            System.out.print(left[i] + " ");
        }
        System.out.println();
        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            System.out.println(stack);
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;
        for (int i = 0; i < right.length; i++) {
            System.out.print(right[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }
}