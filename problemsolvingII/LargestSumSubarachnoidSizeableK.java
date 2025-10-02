public class LargestSumSubarachnoidSizeableK {
    // User function Template for Java
    public static void main(String[] args) {
        System.out.println(maxSumWithK(new long[]{-4 ,-2, 1, -3}, 4, 2));
    }

    public static long maxSumWithK(long a[], long n, long k) {
        long sum=0;
        long[] pre=new long[(int)n];
        pre[0]=a[0];
        long result=Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            pre[i]=Math.max(a[i],pre[i-1]+a[i]);
            System.out.print(pre[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < k; i++) {
            sum+=a[i];
        }
        for (int i = (int) k; i <n ; i++) {
            sum+=a[i]-a[(int) (i-k)];
            result=Math.max(result,sum);
            result=Math.max(result,sum+pre[(int) (i-k)]);
        }
        return result;
    }
}
