public class c1 {
    public static void main(String[] args) {
        System.out.println(gcdOfOddEvenSums(5));
    }
    public  static int gcdOfOddEvenSums(int n) {
        int o=n*n;
        int e=n*(n+1);
        return gcd(o,e);
    }
    static  int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
