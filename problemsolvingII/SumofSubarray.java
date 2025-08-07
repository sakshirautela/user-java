public class SumofSubarray {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,3}));
    }

    public static int subarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((n-i) * (i + 1)) * arr[i];
        }
        return sum;
    }
}
