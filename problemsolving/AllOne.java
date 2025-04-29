import java.util.HashMap;

public class AllOne {

    static class Node {
        String key;
        int count;
        Node next;
        Node prev;

        public Node(String s, int n) {
            count = n;
            key = s;
            next = null;
            prev = null;
        }
    }

    private HashMap<String, Node> nodes = new HashMap<String, Node>();
    Node head;
    Node tail;

    public AllOne() {
        head = new Node("", -1);  // Sentinel node with an invalid count
        tail = new Node("", Integer.MAX_VALUE);  // Sentinel node with an invalid high count
        head.next = tail;
        tail.prev = head;
    }

    // Swap nodes a and b
    private void swap(Node a, Node b) {
        Node t = b.next;
        a.next = t;
        t.prev = a;
        b.next = a;
        t = a.prev;
        t.next = b;
        a.prev = b;
        b.prev = t;
    }

    // Delete a node from the doubly linked list
    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    // Move a node forward if its count is greater than the next node's count
    private void updateInc(Node n) {
        while (n.next != tail && n.count > n.next.count) {
            swap(n, n.next);
        }
    }

    // Move a node backward if its count is less than the previous node's count
    private void updateDec(Node n) {
        while (n.prev != head && n.count < n.prev.count) {
            swap(n.prev, n);
        }
    }

    // Increment the count of the key
    public void inc(String key) {
        Node n = nodes.getOrDefault(key, new Node(key, 0));
        int c = ++n.count;

        // If the key already exists, we update its position in the list
        if (c != 1) {
            if (c > tail.prev.count) {
                delete(n);
                n.next = tail;
                n.prev = tail.prev;
                tail.prev.next = n;
                tail.prev = n;
            } else {
                updateInc(n);
            }
        } else {  // If it's a new key, we add it to the list at the beginning
            nodes.put(key, n);
            n.prev = head;
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
        }
    }

    // Decrement the count of the key
    public void dec(String key) {
        Node n = nodes.get(key);
        if (--n.count == 0) {
            nodes.remove(key);
            delete(n);
        } else {
            updateDec(n);
        }
    }

    // Get the key with the maximum count
    public String getMaxKey() {
        return head.next == tail ? "" : tail.prev.key;
    }

    // Get the key with the minimum count
    public String getMinKey() {
        return head.next == tail ? "" : head.next.key;
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("key1");
        obj.inc("key1");
        obj.inc("key2");
        System.out.println(obj.getMaxKey());  // Returns "key1"
        System.out.println(obj.getMinKey());  // Returns "key2"
        obj.dec("key1");
        System.out.println(obj.getMaxKey());  // Returns "key2"
    }
}
