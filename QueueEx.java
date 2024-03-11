public class QueueEx {
    static int capacity=10;
    static int end=-1;
    int front =0;
    static Object[] queue =new Object[capacity];

    //insertion
    Object enqueue(Object data){
        if(isFull()){
            System.out.println("queue if full");
        }
        end++;
        queue[end]=data;
        return queue[end];
    }

    //deletion 
    Object dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty");
        }
        for(int i=1;i<end;i++){
            queue[i-1]=queue[i];
        }
        end--;
        return queue[front];
    }

    //peek(front)
    // checking empty queue
    boolean isEmpty(){
        return front==-1;
    }

    //checking full
    boolean isFull(){
        return end==capacity;
    }
    public static void main(String[] args) {
        QueueEx q = new QueueEx();
        q.enqueue("frist");
        q.enqueue("second");
        q.enqueue("third");
        q.enqueue("sakshi");
        q.enqueue("mid");
        q.enqueue(12);
        q.enqueue(34);
        q.enqueue(45);
        q.enqueue("end");
        System.out.println(q.dequeue());

        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        for(int i=0;i<=end;i++){
            System.out.print(queue[i]+" ");
        }

    }
}
