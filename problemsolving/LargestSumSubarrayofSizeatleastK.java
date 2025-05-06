public class LargestSumSubarrayofSizeatleastK {
    public static void main(String[] args) {
        System.out.println(maxSumWithK(new long[] { -4, -2, 1, -3 }, 4, 2));
    }

    public static long maxSumWithK2(long a[], long n, long k) {
        long max = 0;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        for (int i = (int) k; i < n; i++) {
              if(sum<0){
                sum=0;
              }
        }
        return sum;
    }

    public static long maxSumWithK(long a[], long n, long k) {
        long size = 0;
        long sum = 0;
        long maxsum = Long.MIN_VALUE;
        for (int index = 0; index < n; index++) {
            if (size < k) {
                sum += a[index];
                size++;
            } else {
                if (sum > maxsum) {
                    maxsum = sum;
                }
                if (sum < 0) {
                    sum = 0;
                    size = 0;
                } else {
                    sum += a[index];
                    size++;
                }
            }
        }
        if (size > k) {
            if (sum > maxsum) {
                maxsum = sum;
            }
        }
        return maxsum;
    }
}