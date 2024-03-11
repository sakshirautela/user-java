import java.util.Stack;

public class QueueUsingTwoStack {
    public static void main(String[] args) {
        QueueUsingTwoStack q=new QueueUsingTwoStack();
        add(3);
        add(0);
        System.out.println(q.peek());

        while (!q.empty()) {
            System.out.println(remove());
        }
    }
    
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static void add(int data){
        //s1->s2
        while (!s1.empty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        //s2->s1
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    public static int remove(){
        if(s1.empty()){
            return -1;
        }
        return s1.pop();
    }
    public boolean empty(){
        if(s1.empty()){
            return true;
        }
        return false;
    }
    public int peek(){
        if(s1.empty()){
            return -1;
        }
        return s1.peek();
    }
}
