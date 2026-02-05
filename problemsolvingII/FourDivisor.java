public class FourDivisor {
    static void main() {
        System.out.println(sumFourDivisors(new int[]{1,2,3,4,5}));
    }

    public static int sumFourDivisors(int[] nums) {
        int result=0;
        for(int num:nums){
            int getsum=divisorSum(num);
            if(getsum!=-1){
                result+=getsum;
            }
        }
        return result;
    }

    private static int divisorSum(int num) {
        int p= (int) Math.cbrt(num);
        System.out.println(p);
        if(p*p*p==num && isPrime(p)){
            return 1+p+p*p+num;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0) {
                int a = num / i;
                if (a!=i && isPrime(a) && isPrime(i)) {
                    return 1 + a + i + num;
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }

    private static boolean isPrime(int p) {
        if(p==2){
            return true;
        }
        if(p%2==0 || p<2){
            return false;
        }
        for(int i=3;i*i<=p;i++){
            if(p%i==0){
                return false;
            }
        }
        return true;
    }

    public static int sumFourDivisorsSlow(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int num : nums) {
            int div = 1 + num;
            int count = 2;
            int i = (num % 2 == 0) ? 2 : 3;
            for (; i*i<num; i ++) {
                if (num % i == 0) {
                    count++;
                    div += i;
                }
            }
            if (count == 4) {
                result += div;
            }
        }
        return result;
    }
}