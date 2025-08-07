public class SumofDivisors1ton {
    public static void main(String[] args) {
        System.out.println(sumOfDivisors(4));
        }
        public static long sumOfDivisors(long n) {
            // code here
            long result=0;
            for(long i=1;i<=n;i++){
                result+=(n/i)*i;
                System.out.println(n/i);
            }
            return  result;
    }
}
