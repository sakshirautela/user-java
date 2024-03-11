import java.util.ArrayList;

public class StackArrayList {
    int top=-1;
    ArrayList<Object> stack=new ArrayList<>();

    public static void main(String args[] ){
        StackArrayList st=new StackArrayList();
        st.push("sakshi");
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
        
    }
    Object push(Object data){
        ++top;
        return stack.add(data);
    }
    Object pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        Object s=stack.get(top);
        --top;
        return s;
    }
    Object top(){
        return stack.get(top);
    }
    boolean isEmpty (){
        return (top==-1);

    }
}