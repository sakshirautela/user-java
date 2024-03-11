import java.util.Stack;

class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length;i++) {
            String str=tokens[i];
            if(str.equals("+") || str=="-" || str=="*" || str=="/"){
                int val1=stack.pop();
                int val2=stack.pop();
                switch(str){
                    case "+":stack.push(val1+val2);break;
                    case "-" :stack.push(val1-val2);break;
                    case "*":stack.push(val1*val2);break;
                    default:stack.push(val1/val2);break;
                }
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","12","+"}));
    }
}