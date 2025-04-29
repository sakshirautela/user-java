
import java.util.Stack;
public class LongestvalidParenthesesGFG {
    static int maxLength(String S){
        int n=S.length();
        if(n==0){
            return 0;
        }
        Stack<Integer> st=new Stack<Integer>();
        int res=0;
        st.push(-1);
        for (int i = 0; i < n; i++) {
            if(S.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.empty()){
                    st.push(i);
                }   
                res=Math.max(res,i-st.peek());
                
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(maxLength("()()()"));
    }
}
