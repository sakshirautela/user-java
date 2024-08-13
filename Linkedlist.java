import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    public Integer val;

    ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}

public class Linkedlist {
    static ListNode head;

    public static void main(String... args) {
        Linkedlist list = new Linkedlist();
        ListNode node = new ListNode(1);
        // System.out.println(node.val);
        list.insert(node, 2);
        //list.insertFromStrat(node, "sakshi");
        //list.insert(node, "sa");
        //list.insert(node, 78);
        System.out.println(countNode(node));

        list.Display(node);
        removeNthFromEnd(node, 1);
        // System.out.println(node.data);
        list.Display(node);

    }

    ListNode insert(ListNode node, int i) {
        // Node new_node=new Node(i);
        // head=node;
        if (node == null) {
            node = new ListNode(i);
            return node;
        }
        head = node;
        while (head.next != null) {
            head = head.next;
        }
        head.next = new ListNode(i);

        return node;
    }

    ListNode insertFromStrat(ListNode node, int i) {
        ListNode new_node = new ListNode(i);
        head = new_node;
        new_node.next = node;
        // System.out.println(new_node.data);
        System.out.println(head.val);
        return head;
    }

    void Display(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static int countNode(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // if (head == null) {
        //     return null;
        // }
        // ListNode curr = head;
        // ListNode temp = head;
        // for (int i = 0; i < n; i++) {
        //     curr = curr.next;
        // }
        // if (curr == null) {
        //     head = head.next;
        //     return head;
        // }

        // while ((curr.next) != null) {
        //     curr = curr.next;
        //     temp = temp.next;

        // }
        // temp.next = temp.next.next;
        // return head;
        int count=countNode(head);
        if(n==count){
            return head.next;
        }
        System.out.println(count);
        ListNode curr=head;
        int j=1;
        while(j<=count-n-1){
            curr=curr.next;
            j++;
        }
        curr.next=(curr.next==null)?null:curr.next.next;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return temp.next;

    }

    /*(public ListNode isPalindromic(ListNode head){
        int mid=countNode(head)/2;
        while(

        )
    }*/
    public ListNode mergeNodesBetweenZeroes(ListNode head) {
        ListNode ptr=head.next; 
        ListNode temp=head; 
        int sum=0;
        while (ptr!=null) {
            while (ptr!=null && ptr.val!=0) {
                sum+=ptr.val;
                ptr=ptr.next;
            }
            if(ptr.val==0){
                temp.next.val=sum;
                sum=0;
                temp=temp.next;
            }
        }
        temp.next=null;
        return head.next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        ListNode temp=headA;
        hm.put(temp.val, 1);
        while (temp.next!=null) {
            hm.put(temp.next.val, 1);
            temp=temp.next;
        }
        temp=headB;
        ListNode res=null;
        while (temp!=null) {
            while(temp!=null && hm.containsKey(temp.val)){
                temp=temp.next;
            }
            if(temp==null){
                return res;
            }
            res=temp;
            temp=temp.next;
        }
        return res;
    }

}
