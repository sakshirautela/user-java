package problemsolvingIII;

import java.util.ArrayList;

public class MaximumTwinSumofaLinkedList {
    static void main() {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static int pairSum(ListNode head) {
//        int result = 0;
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int sum = 0;
        for(int i=0;i<n/2-1;i++){
            sum=Math.max(sum,list.get(i)+list.get(n-1-i));
        }
        return sum;
    }
}
