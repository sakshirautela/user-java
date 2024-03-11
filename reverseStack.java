import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
    public static void reverse(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int data=s.pop();
        reverse(s);
        pushAtBottom(s,data);
    }
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.empty()){
            s.push(data);
            return;
        }
        int val = s.pop();
        pushAtBottom(s,data);
        s.push(val);

    }
}
