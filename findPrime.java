public class findPrime {
    public static void main(String[] args) {
        System.out.println(prime(10));
    }
    public static boolean prime(int n){
        if(n<2){
            return false;
        }
        if(n<4){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
