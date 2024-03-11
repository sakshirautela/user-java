import java.util.Stack;

class BasicCalculator {
    public static int calculate(String s) {
        String result = "";        
        String str = "";
        String ch="";
        int ans=0;
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            ch += s.charAt(i);
            if(ch==")"){
                while (!st.isEmpty() && !st.peek().equals('(')) {
                    result=st.pop()+result;
                    solver(result);
                }
                st.pop();
            }
            else if(ch==" "){
                ch="";
                continue;
            }
            else if(ch==" " || ch==" "){
                st.push(str);
                str="";
                st.push(ch);
                ch="";
            }
        }
        return ans;
    }
    private static String solver(String str) {
        return "";
    }
    public static void main(String[] args) {
        System.out.println(calculate(""));
    }
}