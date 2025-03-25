import java.util.HashSet;

public class LengthofLongestFibonacciSubsequence {
    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[] {}));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int result = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hs.add(i);
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prev = arr[i];
                int curr = arr[j] + prev;
                int len = 2;
                while (hs.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    len++;
                    result = Math.max(len, result);
                }
            }
        }
        return (result <= 2) ? 0 : result;
    }

    public int lenLongestFibSubseq1(int[] arr) {
        HashSet<Integer> index = new HashSet<>();
        for (int n : arr) {
            index.add(n);
        }
        int max = 2;
        for (int i = 0; i < arr.length - max; i++) {
            if (arr[i] * Math.pow(1.618, max - 1) > arr[arr.length - 1])
                break;
            for (int j = i + 1; j < arr.length - max + 1; j++) {
                if (arr[j] * Math.pow(1.618, max - 2) > arr[arr.length - 1])
                    break;
                int n2 = arr[i];
                int n1 = arr[j];
                int len = 2;
                while (index.contains(n1 + n2)) {
                    n1 = n1 + n2;
                    n2 = n1 - n2;
                    len++;
                }
                if (len > max)
                    max = len;
            }
        }
        return max < 3 ? 0 : max;
    }
}