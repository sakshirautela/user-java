class TreeNode{
    int data;
    TreeNode next;
    TreeNode(int val){
        this.data=val;
        this.next=null;
    }
}

public class LinkedLIstApnaCollege {
    static TreeNode head;
    static TreeNode tail;
    public static int idx=0;

    public  TreeNode addFirst(int val){
        TreeNode node = new TreeNode(val);
        idx++;
        if(head==null){
            head=tail=node;
        }
        node.next=head;
        head=node;
        return head;
    }
    
    public  void addLast( int val) {
        TreeNode node = new TreeNode(val);
        idx++;
        if (head == null) {
            head = tail = node;
        }
        tail.next = node;
        tail=node;
    }
    public void Display(){
        if(head==null){
            return ;
        }
        TreeNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public int recrsiveHeplper(TreeNode head,int key){
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        idx = recrsiveHeplper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }
    public int recursiveSearch(int key){
        return recrsiveHeplper(head, key);
    }
    public void reverse(){
        TreeNode current=head;
        TreeNode prev=null;
        TreeNode next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    public void removeNthNode(int n){
        int size=idx-n+1;
        TreeNode current=head;
        while(size>1){
            current=current.next;
            size--;
        }
        current=current.next.next;
        return;
    }
    public TreeNode slowFast(TreeNode head){
        TreeNode slow=head;
        TreeNode fast=head;
        while(slow!=null && ( fast.next!=null)){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean palindrome() {
        if(head==null || head.next==null){
            return true;
        }
        //step1 find mid
        TreeNode mid=slowFast(head);

        //step2 reverse half
        TreeNode prev=null;
        TreeNode current=mid;
        TreeNode next;
        while (current !=null) {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        mid=prev;

        //step3 check left right
        TreeNode right=head;
        TreeNode left=prev;
        while (right!=null) {
            if(right.data!=left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedLIstApnaCollege llist=new LinkedLIstApnaCollege();
        llist.addFirst( 67);
        //llist.addFirst( 67);
        //llist.addFirst( 67);
        //llist.addFirst( 67);
        // llist.addLast( 57);
        // llist.addLast( 57);
        // llist.addLast( 7);
        llist.Display();
        // System.out.println(idx);
        // System.out.println(llist.recursiveSearch(7));
        // llist.reverse();
        //llist.removeNthNode(2);
        //llist.Display();

        //System.out.println(idx);
        System.out.println(llist.palindrome());

        llist.Display();
    }

}
