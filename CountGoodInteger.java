public class CountGoodInteger {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(5));
    }
    static int mod=1000000007;
    public static int countGoodNumbers(long n) {
        return getPow(5,(n+1)/2)*getPow(4,(n)/2);
    }
    private static int getPow(int x, long y) {
        int mul=x;
        int res=1;
        while(y>0){
            if(y%2==1){
                res=(res*mul)%mod;
            }
            mul=(mul*mul)%mod;
            y/=2;
        }
        return res;
    }
}