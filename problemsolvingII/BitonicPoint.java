public class BitonicPoint {
    public static void main(String[] args) {
        System.out.println(new BitonicPoint().findMaximum(new int[] { 1, 3, 8, 12, 4, 2 }));
    }
    public int findMaximum(int[] arr) {
        // code here
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return arr[n - 1];
    }
}