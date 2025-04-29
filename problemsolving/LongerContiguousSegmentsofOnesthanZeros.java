
public class LongerContiguousSegmentsofOnesthanZeros {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("111000"));
    }
    public static boolean checkZeroOnes(String s) {
        int n=s.length();
        int o=0;
        int zero=0;
        int one=0;
        int z=0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='0'){
                zero++;
                o=Math.max(o,one);
                one=0;
            }else{
                one++;
                z=Math.max(z,zero);
                zero=0;
            }
        }
        o=Math.max(o,one);
        z=Math.max(z,zero);
        return (o>z);
    }
}
