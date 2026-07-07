package problemsolvingIII;

public class PalindromeBinary {
    static void main() {
        System.out.println(isBinaryPalindrome(3));
    }
    public static boolean isBinaryPalindrome(int n) {
        // code here
        int num=n;
        int rev=0;
        while(num!=0){
            int b=num&1;
            num=num>>1;
            rev=rev<<1 ;
            rev=rev|b;
        }
        System.out.println(rev+" "+n);
        return rev==n;
    }
}