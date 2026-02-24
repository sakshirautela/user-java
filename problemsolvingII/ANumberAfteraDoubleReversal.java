public class ANumberAfteraDoubleReversal {
    static void main() {
        System.out.println(isSameAfterReversals(    1400));
    }
    public static boolean isSameAfterReversals(int num) {
int n=rev(rev(num));
return n==num;
    }

    private static int rev(int num) {
        int res=0;
        while(num!=0) {
            res=res*10+num%10;
            num=num/10;
        }
        return res;
    }
    public boolean isSameAfterReversalsSimpleLogic(int num) {
        if(num == 0)
            return true;
        if(num % 10 == 0)
            return false;
        return true;
    }
}