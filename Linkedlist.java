class ListNode {
    Object data;
    ListNode next;

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

}
