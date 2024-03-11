public class CountPrime {
    

    public static boolean isPrime(int i){
        if(i==2){
            return true;
        }
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int n=10;
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
