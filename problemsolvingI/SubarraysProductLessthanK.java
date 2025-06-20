public class SubarraysProductLessthanK {
    public static void main(String[] args) {
        System.out.println(countSubArrayProductLessThanK(new long[]{},4,3));
    }
    public static long countSubArrayProductLessThanK(long arr[], int n, long k) {
        long result=0;
        int j=0;
        long prod=1;
        for (int i = 0; i < n; i++) {
            prod*=arr[i];
            while (i<j && prod>=k) {
                prod/=arr[j];
                j++;
            }
            result+=(i-j+1);
        }
        return result;
    }
}