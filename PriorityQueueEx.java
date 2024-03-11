class Node{
    Object data;
    int priority;
    Node next;
    Node(Object data,int priority){
        this.data=data;
        this.priority=priority;
        this.next=next;
    }
}
public class PriorityQueueEx {
    static Node head;
    Node enqueue(Object a,int b){
        Node temp=head;
        Node newnode =new Node(a,b);
        if(head==null){
            head=newnode;
        }
        else{
            if(temp.next!=null && b<temp.next.priority){
               newnode.next=temp.next;
               temp=newnode; 
            }
            else{
               temp.next=newnode; 
            }
        }
        return head;
    }
    Node dequeue(){
        if(head==null){
            return head;
        }
        Node curr=head;
        head=head.next;
        return head;
    }
    Object peek(){
        return head.data;
    }
    public static void main(String[] args) {
        PriorityQueueEx queue=new PriorityQueueEx();
        queue.enqueue("sakshi", 14);
        queue.enqueue("abc", 3);
        queue.enqueue(12, 2);
        queue.enqueue(34, 5);
        queue.enqueue(45, 1);
        queue.enqueue(23, 4);
        queue.enqueue(22, 6);
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
       // System.out.println(queue.peek());

    }
}
