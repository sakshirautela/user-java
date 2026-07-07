package problemsolvingIII;

import java.util.*;

public class RemoveInvalidParentheses {
    static void main() {
        System.out.println(validParenthesis("()())()"));
//        System.out.println(isValid("())".toCharArray()));
    }

    public static List<String> validParenthesis(String s) {
        // code here
        int n = s.length();
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int open=0,close=0;
        for(char c : arr) {
            if(c=='('){
                open++;
            }else if(c==')'){
                if(open!=0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        validParenthesisUtil(arr, 0, n,open,close,0,"",ans,set);
        return ans;
    }

    private static void validParenthesisUtil(char[] arr, int i, int n, int open, int close, int pair, String s, List<String> ans, HashSet<String> set) {
        if(i==n){
            if(open==0 && close==0 && pair==0){
                if (!set.contains(s)) {
                    ans.add(s);
                    set.add(s);
                }            }
            return;
        }
        if(arr[i]!='(' && arr[i]!=')'){
            validParenthesisUtil(arr,i+1,n,open,close,pair,s+arr[i],ans,set);
        }else{
            if(arr[i]==')' ){
                if(close>=1){
                    validParenthesisUtil(arr,i+1,n,open,close-1,pair,s,ans,set);
                }
                if(pair>0) {
                    validParenthesisUtil(arr, i + 1, n, open, close , pair - 1, s + arr[i], ans, set);
                }
            }else{
                if(open>=1){
                    validParenthesisUtil(arr,i+1,n,open-1,close,pair,s,ans,set);
                }
                validParenthesisUtil(arr, i + 1, n, open, close, pair + 1, s + arr[i], ans, set);
            }
        }
    }
}