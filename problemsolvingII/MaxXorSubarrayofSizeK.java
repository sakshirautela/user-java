public class MaxXorSubarrayofSizeK {
    static void main() {
        System.out.println(maxSubarrayXOR(new int[]{1,2,3,4,5,6,7,8,9,10}, 2));
    }
        public  static int maxSubarrayXOR(int[] arr, int k) {
            // code here
            int xor = 0;
            int n = arr.length;
            for (int i = 0; i <k ; i++) {
                xor ^= arr[i];
            }
            int max = xor;
            for (int i = k ; i < n ; i++) {
                xor^=arr[i-k];
                xor ^= arr[i];
                max=Math.max(max,xor);
            }
            return max;
        }
    }
