public class IsPrimeNumber {
    public static boolean isPrime(int A) {
        for(int i=2;i<=A/2;i++){
            if(A%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(isPrime(3));
    }
}
