import java.util.Stack;

public class ReverseStringPara {
    public static void main(String[] args) {
        String str="(u(love)i)";
        System.out.println(reverseParenthesesII(str));
    }
    public static String reverseParenthesesII(String str) {
        Stack<Character> stack = new Stack<Character>();
        String s="";
        for (Character c :str.toCharArray()){
            if(c==')'){
                while (stack.peek()!='('){
                    s+=stack.pop();
                }
                stack.pop();
                String res="";
                int i=0;
                while(!s.equals(res)) {
                    res+=s.charAt(i);
                    stack.push(s.charAt(i));
                    i++;
                }
                s="";
            }else{
                stack.push(c);
            }
        }
        String result="";
        System.out.println(stack);
        while (!stack.isEmpty()) {
            result=stack.pop()+result;
        }
        return result;
    }
    // public static String reverseParentheses(String s) {
    //     String res="";
    //     int count=0;
    //     int len=0;
    //     Stack<String> st = new Stack<String>();
    //     for (int i = 0; i < s.length(); i++) {
    //         if(s.charAt(i)!=')' && s.charAt(i)!='('){
    //             len++;
    //         }
    //     }
    //     if(len==s.length()){
    //         return s;
    //     }
    //     for (int i=0; i<s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(ch =='('){
    //             st.push(res);
    //             res="";
    //         }
    //         else if(ch == ')'){
    //             count++;
    //             if(!st.isEmpty()){
    //                 if(count==1){
    //                     String a=st.pop();
    //                     st.push(a+reverse(res));
    //                 }
    //                 else if(st.size()>1){
    //                     String ex=(st.pop()+res);
    //                     st.push(st.pop()+reverse(ex));
    //                 }
    //                 else{
    //                     st.push(reverse(st.pop()+(res)));
    //                 }
    //             }
    //             else{
    //                 st.push(reverse(res));;
    //             }
    //             res="";
    //         }
    //         else if(ch != ')' && ch != '('){
    //             res+=ch;
                
    //         }
    //         System.out.println(st);
    //     }
    //     if(res!=""){
    //         st.push(st.pop()+res);
    //     }
    //     return st.pop();

    // }
    // public static String reverse(String s){
    //     String res="";
    //     for(int i=0; i<s.length(); i++){
    //         res=s.charAt(i)+res;
    //     }
    //     return res;
    // }
}
