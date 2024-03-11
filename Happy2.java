public class Happy2 {
    public static boolean isHappy(int n) {
        return valid(n);
    }
    public static boolean valid(int n) {
        if (n==1) {
            return true;
        }
        else if(n==4){
            return false;
        }
        int sum=0;
        while (n>0) {
            int rem = n % 10;
            sum += Math.pow(rem, 2);
            n = n / 10;
        }
        return valid(sum);
    }
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
}