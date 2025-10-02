import java.util.Stack;

public class MinimumAddTpMakeParanthesisValid {
    public static void main(String[] args) {
        System.out.println(minParentheses(""));
    }
    public static int minParentheses(String s) {
        // code here
        Stack<Character> st=new Stack<>();
        int opretion=0;
for(char ch:s.toCharArray()){
    if(ch=='('){
        st.push(ch);
    }else if(!st.isEmpty() && ch==')'){
        st.pop();
    }else {
        opretion++;
    }
}
return opretion+st.size();
    }
}
