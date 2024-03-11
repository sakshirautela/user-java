import java.util.Stack;
public class StackExample {
    public static void main(String[] args) {
        Stack<Object> stack =new Stack();
        stack.push("sakshi");
        stack.push("sakshi");
        stack.push("sakshi");
        stack.push(89);
        stack.push("sakshi");
        stack.push("sakshi");
        stack.push("sakshi");
        stack.push("sakshi");
        stack.push("sakshi");
        stack.pop();
        stack.peek();
        System.out.println(stack.empty());

        stack.add(1, "stack");
        System.out.println(stack);
    }
}
