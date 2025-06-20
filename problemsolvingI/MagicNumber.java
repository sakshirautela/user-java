public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(isMagicNumber(1729));
    }

    private static boolean isMagicNumber(int num) {
        for(int i=1;i*i*i<=num;i++){
            int one=i*i*i;
            int rem=num-one;
            double n=Math.pow(rem,0.3);
            if(rem==n){
                return true;
            }
        }
        return false;
    }
}
