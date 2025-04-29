
class MyCircularDeque {
    static class DequeNode{
        int val;
        DequeNode next;
        DequeNode prev;
        public DequeNode(int val,DequeNode next,DequeNode prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
        public DequeNode(){
            this.next=null;
            this.prev=null;
        }
    }
    int size;
    int k=0;
    DequeNode head;
    DequeNode tail;
    public MyCircularDeque(int k) {
        size=k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head=new DequeNode(value,null,null);
            tail=head;
        }else{
            DequeNode node=new DequeNode(value,head,null);
            head.prev=node;
            head=node;
        }
        k++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        if(head==null){
            head=new DequeNode(value,null,null);
            tail=head;
        }else{
            tail.next=new DequeNode(value,null,tail);
            tail=tail.next;
        }
        k++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else if(k==1){
            head=null;
            tail=null;
        }
        else{
            head=head.next;
        }
        k--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else if(k==1){
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
        }
        k--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }
    
    public int getRear() {
        if(!isEmpty()){
            return tail.val;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return (k==0);
    }
    
    public boolean isFull() {
        return (size==k);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
