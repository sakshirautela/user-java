import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class ListNode {
    Object data;
    ListNode next;
    public Integer val;

    ListNode(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class Linkedlist {
    static ListNode head;

    public static void main(String... args) {
        Linkedlist list = new Linkedlist();
        ListNode node = new ListNode(45);
        // System.out.println(node.data);
        list.insert(node, 34);
        list.insertFromStrat(node, "sakshi");
        list.insert(node, "sa");
        list.insert(node, 78);
        list.countNode(node);

        list.Display(node);
        // removeNthFromEnd(node, 2);
        // System.out.println(node.data);
    }

    ListNode insert(ListNode node, Object i) {
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

    ListNode insertFromStrat(ListNode node, Object i) {
        ListNode new_node = new ListNode(i);
        head = new_node;
        new_node.next = node;
        // System.out.println(new_node.data);
        System.out.println(head.data);
        return head;
    }

    void Display(ListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public int countNode(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            head = head.next;
            return head;
        }

        while ((curr.next) != null) {
            curr = curr.next;
            temp = temp.next;

        }
        temp.next = temp.next.next;
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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> al=new ArrayList<>();
        while(head!=null){
            al.add(head.val);
            head=head.next;
        }
        int i=0;
        int j=al.size()-1;
        while(i<j){
            if(al.get(i)!=al.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hm=new HashSet<>();
        ListNode temp=headA;
        while (temp!=null) {
            hm.add(temp);
            temp=temp.next;
        }
        while (headB!=null) {
            if(hm.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return headB;
    }
    public Node rotate(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }
        Node newHead = current.next;
        current.next = null;
        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return newHead;
    }

}
