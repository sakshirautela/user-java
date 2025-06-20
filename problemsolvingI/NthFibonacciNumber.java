public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(nthFibonacci(5));
    }
    public static int nthFibonacci(int n) {
        // code here
        if(n<=0){
            return 0;
        }
        int[] fib=new int[n+1];
        fib[0]=0;
        fib[1]=1;
        for (int i = 2; i < n+1; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
}