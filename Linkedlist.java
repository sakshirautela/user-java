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
        ListNode node = new ListNode(1);
        // System.out.println(node.data);
        list.insert(node, 2);
        // list.insertFromStrat(node, "sakshi");
        // list.insert(node, "sa");
        // list.insert(node, 78);
        System.out.println(countNode(node));

        list.Display(node);
        removeNthFromEnd(node, 1);
        // System.out.println(node.data);
        list.Display(node);

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
        // return null;
        // }
        // ListNode curr = head;
        // ListNode temp = head;
        // for (int i = 0; i < n; i++) {
        // curr = curr.next;
        // }
        // if (curr == null) {
        // head = head.next;
        // return head;
        // }

        // while ((curr.next) != null) {
        // curr = curr.next;
        // temp = temp.next;

        // }
        // temp.next = temp.next.next;
        // return head;
        int count = countNode(head);
        if (n == count) {
            return head.next;
        }
        System.out.println(count);
        ListNode curr = head;
        int j = 1;
        while (j <= count - n - 1) {
            curr = curr.next;
            j++;
        }
        curr.next = (curr.next == null) ? null : curr.next.next;
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

    /*
     * (public ListNode isPalindromic(ListNode head){
     * int mid=countNode(head)/2;
     * while(
     * 
     * )
     * }
     */
    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        if (head == null || head.next == null)
            return; // Check for empty list or single node

        Node slow = head;
        Node fast = head;

        // Step 1: Detect if a cycle exists using Floyd’s Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps

            if (slow == fast) { // Cycle detected
                break;
            }
        }

        // If fast pointer reached the end, there is no cycle
        if (fast == null || fast.next == null) {
            return;
        }

        // Step 2: Find the start of the cycle
        Node startOfCycle = head;
        while (startOfCycle != slow) {
            startOfCycle = startOfCycle.next; // Move startOfCycle pointer by one step
            slow = slow.next; // Move slow pointer by one step
        }

        // Step 3: Find the node just before the start of the cycle
        Node cycleNode = slow;
        while (cycleNode.next != slow) {
            cycleNode = cycleNode.next; // Move to the end of the cycle
        }

        // Step 4: Remove the cycle
        cycleNode.next = null;

    }

}
