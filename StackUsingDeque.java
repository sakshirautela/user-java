import java.util.*;

class MyStack {
    Deque<Integer> dq;
    public MyStack() {
        dq=new LinkedList();
    }
    
    public void push(int x) {
        dq.addLast(x);
    }
    
    public int pop() {
        int a=dq.removeLast();
        return a;
    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public boolean empty() {
        if(dq.size() == 0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class StackUsingDeque {
    public static void main(String[] args) {
        
    }
}
