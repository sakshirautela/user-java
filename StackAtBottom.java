import java.util.Stack;

public class StackAtBottom {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        pushAtBottom(s, 0);
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.empty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
}
