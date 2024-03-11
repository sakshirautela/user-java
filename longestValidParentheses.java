class longestValidParentheses {
    static int capacity = 10;
    int top = -1;
    static int count=0;
    static char[] stack = new char[capacity];

    char push(char data){
        ++top;
        return stack[top]=data;
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        char s = stack[top];
        --top;
        return s;
    }
    boolean isEmpty() {
        return top==-1;
    }
    char top(){
        return stack[top];
    }

    static boolean isMatching(char ch,char ch2){
        return ((ch == '{' && ch2 == '}') || (ch == '[' && ch2 == ']')
        || (ch== '(' && ch2 == ')'));
    }
    public static void main(String[] args) {
        longestValidParentheses st=new longestValidParentheses();
        String s="(()))";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' ||s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else if(isMatching(s.charAt(i),st.top())){
                count++;
                st.pop();
               
            }
        }
        System.out.println(count);
    }
}   
