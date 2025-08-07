// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode current = head;
        while (current != null) {
            num = (num << 1) | current.val;
            current = current.next; 
        }
        return num;
    }
}