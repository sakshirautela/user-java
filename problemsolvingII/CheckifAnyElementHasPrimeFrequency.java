import java.util.HashMap;

public class CheckifAnyElementHasPrimeFrequency {
    public static void main(String[] args) {
        System.out.println(checkPrimeFrequency(new int[]{}));
    }
    public static boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int  i : nums) {
            hm.put(i,hm.getOrDefault(i, 0)+1);
        }
        for (int i  : hm.keySet()) {
            if(hm.get(i)>1 && isPrime(hm.get(i))){
                return true;
            }
        }
        return false;
    }
    private static boolean isPrime(int f) {
        for(int i=2;i<f-1;i++){
            if(f%i==0){
                return false;
            }
        }
        return true;
    }
}