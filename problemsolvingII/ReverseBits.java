public class ReverseBits {
    static void main() {
        System.out.println(reverseBitsBIt(4));
        System.out.println(reverseBitsFor(5));
    }
    public static int reverseBitsBIt(int n) {
        int res = 0;
        int power=31;
        while (n > 0) {
            res+=(n&1)<<power;
            n=n>>>1;

            power--;

        }
        return res;
    }
    public  static int reverseBitsFor(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>>= 1;
        }
        return res;
    }
        public static int reverseBits(int n) {
        int res=0;
        int power=1;
        StringBuilder sb=getBinary(n);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                res=res+power;
            }
            power *=2;
        }
        return res;
    }

    private static StringBuilder getBinary(int n) {
        StringBuilder sb=new StringBuilder();
        int rem=0;
        while(n!=0){
             rem=n%2;
            sb.insert(0,(rem==0)?'0':"1");
            n=n/2;
        }
        return sb;
    }
}
