import java.util.*;

class ListNode {
    Object data;
    ListNode next;

    ListNode(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class Linkedlist {
    static class Node {
        int data;
        Linkedlist.Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static ListNode head;
    ListNode insert(ListNode node, Object i) {
        head=node;
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
        System.out.println(new_node.data);
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
        //remove the loop without losing any nodes
        if (head == null || head.next == null)
            return; // Check for empty list or single node

        Node slow = head;
        Node fast = head;

        //Step 1: Detect if a cycle exists using Floyd’s Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps

            if (slow == fast) { // Cycle detected
                break;
            }
        }

        //If fast pointer reached the end, there is no cycle
        if (fast == null || fast.next == null) {
            return;
        }

        //Step 2: Find the start of the cycle
        Node startOfCycle = head;
        while (startOfCycle != slow) {
            startOfCycle = startOfCycle.next; // Move startOfCycle pointer by one step
            slow = slow.next; // Move slow pointer by one step
        }

        //Step 3: Find the node just before the start of the cycle
        Node cycleNode = slow;
        while (cycleNode.next != slow) {
            cycleNode = cycleNode.next; // Move to the end of the cycle
        }

        //Step 4: Remove the cycle
        cycleNode.next = null;

    }

    boolean isPalindrome(Node head) {
        //Your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        Node curr = head;
        while (curr != null) {
            al.add(curr.data);
            curr = curr.next;
        }
        int i = 0;
        int j = al.size() - 1;
        while (i < j) {
            if (!al.get(i).equals(al.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public long multiplyTwoLists(Node first, Node second) {
        //Code here
        long mod = 1000000007;
        long firstVal = 0;
        long secondVal = 0;
        while (first != null) {
            firstVal = (firstVal * 10 + first.data) % mod;
            first = first.next;
        }
        while (second != null) {
            secondVal = (secondVal * 10 + second.data) % mod;
            second = second.next;
        }
        return (firstVal * secondVal) % mod;
    }

    //Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head)
            return head;
        Node prev = null;
        Node curr = head;
        do {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } while (curr != head);
        head.next = prev;
        return prev;
    }

    //Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null || (head.next == head && head.data == key))
            return null;
        if (head.data == key) {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = head.next;
            return head.next;
        }
        Node curr = head;
        do {
            if (curr.next.data == key) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        } while (curr != head);
        return head;
    }
    public void deleteAlt(Node head) {
        Node temp=head;
        while(temp!=null && temp.next!=null){
            temp.next=temp.next.next;
            temp=temp.next;
        }
    }
    Node[] alternatingSplitList(Node head) {
        if(head.next==null){
            return new Node[]{head,null};
        }
        Node curr=head.next;
        Node first=head;
        Node second=head.next;
        while(curr!=null){
            first.next=curr.next;
            first=curr;
            curr=curr.next;
        }
        return new Node[]{head,second};
    }
    public static int sumOfLastN_Nodes(Node head, int n) {
        int len=getLen(head);
        len-=n;
        while (len>0) {
            head=head.next;
            len--;
        }
        int sum=0;
        while (head!=null) {
            sum+=head.data;
            head=head.next;
        }
        return sum;
    }

    private static int getLen(Node head) {
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
    private static void Display(Node node) {
        while (node!=null) {
            System.out.println(node.data);
            node=node.next;
        }
    }
    public static Node quickSort(Node node) {
        // Your code here
        ArrayList<Integer> ar=new ArrayList<Integer>();
        Node temp=node;
        while (temp!=null) {
            ar.add(temp.data);
            temp=temp.next;
        }
        Collections.sort(ar);
        temp=node;
        while (temp!=null) {
            temp.data=ar.get(0);
            ar.remove(0);
            temp=temp.next;
        }
        return node;
    }
    public static void main(String... args) {
        int[] arr={5,6,9,3,4,10};
        Node node = new Node(0);
        Node curr=node;
        for (int d : arr) {
            curr.next=new Node(d);
            curr=curr.next;
        }
        Display(node);
        System.out.println(sumOfLastN_Nodes(node.next,3));
    }

}
