
public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        while(n%3 == 0){
            n /= 3;
        }
        if(n == 1){
            return true;
        }
        return false;
    }
    public static boolean isPowerOfThree2(int n) {
        return (n>0 && (1162261467%n==0));
    }
    
    public static void main(String agrs[]){
        System.out.println(isPowerOfThree(2069870691));
    }
}
