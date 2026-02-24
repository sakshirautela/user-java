public class CheckBalancedString {
    static void main() {
        System.out.println(isBalanced("s"));
    }
    public static boolean isBalanced(String num) {
int n=num.length();
int even=0,odd=0;
for(int i=0;i<n;i++){
    if(i%2==0){
        even+=(num.charAt(i)-'0');
    }else{
        odd+=(num.charAt(i)-'0');
    }
}
return even==odd;
    }
}