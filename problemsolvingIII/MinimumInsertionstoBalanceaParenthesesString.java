package problemsolvingIII;

public class MinimumInsertionstoBalanceaParenthesesString {
    static void main() {
        System.out.println(minInsertions("))())("));
    }
    public static int minInsertions(String s) {
        int n = s.length();
        int result=0;
        int open = 0;
        for (int i = 0; i <n; i++) {
            if(s.charAt(i) == '(') {
                open++;
            }
            else if(i<n-1 &&  s.charAt(i ) == ')' && s.charAt(i + 1) == ')') {
                if(open<=0){
                    result++;
                }else{
                    open--;
                }
                i++;
            }else{
                if(open>0){
                    open--;
                }else{
                    result++;
                }
                result++;
            }
        }
        result+=(open*2);
        return result;
    }
}
