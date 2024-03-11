import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/."));
    }
    public static String simplifyPath(String path) {
        int len=path.length();
        Stack<String> stack = new Stack<String>();
        String res="";        
        String ans="/";

        for (int i = 0; i < len; i++) {
            if(path.charAt(i)=='/') {
                if(res.equals("..") || res.equals(".")){
                    if(!stack.isEmpty() && res.equals("..")){
                        stack.pop();
                    }
                }
                else if(res==""){
                    continue; // ignore
                }
                else{
                    stack.push(res);
                }

                res="";
            }
            else{
                res+=path.charAt(i);
            }
        }
        if(res.equals("..") && !stack.isEmpty()){
            stack.pop();
        }
        else if(!res.equals("") && !res.equals(".")){
            stack.push(res);
        }
        while (!stack.isEmpty()) {
            if(stack.peek()=="."){ continue;}
            else{ans="/"+stack.pop()+ans;}
        }
        if (ans.length() > 1 && ans.charAt(ans.length() - 1) == '/') {
            ans = ans.substring(0, ans.length()-1 );
        }
        return ans;
        
    }
}