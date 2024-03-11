import java.util.Stack;

// public class Paranthesis {
//     static int capacity = 10;
//     int top = -1;
//     static char[] stack = new char[capacity];

//     char push(char data) {
//         ++top;
//         return stack[top] = data;
//     }

//     char pop() {
//         if (isEmpty()) {
//             System.out.println("Stack is empty");
//         }
//         char s = stack[top];
//         --top;
//         return s;
//     }

//     char top(){
//         return stack[top];
//     }

//     boolean isEmpty() {
//         return (top == -1);

//     }

//     boolean isFull() {
//         return (top == capacity - 1);
//     }
//     static boolean isMatching(char ch,char ch2){
//         return ((ch == '{' && ch2 == '}') || (ch == '[' && ch2 == ']')
//         || (ch== '(' && ch2 == ')'));
//     }

//     public static void main(String args[]) {
//         Stack sc = new Stack();
//         String str = "{([])}";
//         for (int i = 0; i < str.length(); i++) {
//             if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
//                 sc.push(str.charAt(i));
//             } else {
//                 if (sc.isEmpty()) {
//                     System.out.println("in -valid");
//                 } else if (isMatching(sc.top(),str.charAt(i))) {
//                     System.out.println(sc.pop());

//                 }
//                 else{
//                     System.out.println("in -valid");

//                 } 
//             }
//         }
//         // for(int i=0;i<str.length();i++){
//         // if((str.charAt(i)== '{' && sc.top=='}') || (str.charAt(i)== '[' &&
//         // sc.top==']') ||(str.charAt(i)== '(' && sc.top==')') ){
//         // System.out.println(sc.pop());
//         // }
//         // }
//         if (sc.isEmpty()) {
//             System.out.println("valid");
//         } 

//     }
// }
public class Paranthesis {
    public static void main(String[] args) {
        String str="()";
        System.out.println(ieValid(str));
    }
    public static boolean ieValid(String str){ //o(n)
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                s.push(ch);
            }
            else{
                if(s.empty()){
                    return false;
                }
                if((ch==']'&& s.peek()=='[') || (ch == ')' && s.peek() == '(') || (ch == '}'
                        && s.peek() == '{')){
                    s.pop();
                }
                else{
                    return false;

                }
            }
        }
        if(s.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}
