import java.util.Arrays;
import java.util.Stack;

public class ValidParenthesisString {
    static void main() {
        System.out.println(checkValidString("(((((*)))**"));
    }

    private static boolean checkValidString(String s) {
       int n = s.length();
       if(s.charAt(0) == ')'){
           return false;
       }
        Stack<Integer> open = new Stack<>();
        Stack<Integer> ch = new Stack<>();
       for(int i=0;i<n;i++) {
           if(s.charAt(i)=='(' ) {
               open.push(i);
           }else if (s.charAt(i)!='(' && s.charAt(i)!=')'){
               ch.push(i);
           }else  {
               if(!open.isEmpty()){
                   open.pop();
               }else if(!ch.isEmpty()){
                   ch.pop();
               }else{
                   return false;
               }
           }
       }
       while(!open.isEmpty() && !ch.isEmpty()) {
            if(open.peek()>ch.peek()) {
                return false;
            }
            open.pop();
            ch.pop();
       }
       if(!open.isEmpty()){
           return false;
       }
       return true;
    }

}
