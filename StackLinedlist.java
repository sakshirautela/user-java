class Node{
    Object data;
    Node next;
    Node(Object data){
        this.data=data;
        this.next=null;
    }
}

public class StackLinedlist {
    static Node head;
    Object push(Object data){
        Node node =new Node(data);
        if(isEmpty()){
            head=node;
        }
        node.next=head;
        head=node;
        return head.data;
        
    
    }
    boolean isEmpty(){
        return head==null;
    }
    Object pop(){
        if(isEmpty()){
            System.out.println("empty");
        }
        Node temp=head;
        head=head.next;
        return temp.data;
    
    }
    Object top(){
        return head.data; 
    }
    public static void main(String args[]){
        StackLinedlist  st=new StackLinedlist();
        //Node node =new Node("sakshi");
        System.out.println(st.isEmpty());

        st.push(67);
        st.push(27);
        st.push(67);
        st.push(47);
        st.push("sakshi");
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.isEmpty());
    }
}
