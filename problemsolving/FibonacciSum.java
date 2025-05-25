public class FibonacciSum {
    public static void main(String[] args) {
        System.out.println(fibSum(5));
    }
    static long fibSum(long N) {
        // code here
        if(N<3){
            return N;
        }
        int mod=1000000007;
        long sum=2;
        long a=1;
        long b=1;
        for (int i = 3; i <=N; i++) {
            long s=(a+b)%mod;
            sum=(sum+s)%mod;
            b=a;
            a=s;
        }
        return sum;       
    }
}