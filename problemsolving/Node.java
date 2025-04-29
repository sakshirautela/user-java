import java.util.HashMap;

public class Node {
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
class AllOne {
    private HashMap<String, Node> nodes = new HashMap<String, Node>();
    Node head;
    Node tail;

    public AllOne() {
        head = new Node("", -1);
        tail = new Node("", Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    //b is directly after a
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

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void updateInc(Node n) {
        while (n.next != tail && n.count > n.next.count) {
            swap(n, n.next);
        }
    }

    private void updateDec(Node n) {
        while (n.prev != head && n.count < n.prev.count) {
            swap(n.prev, n);
        }
    }
    
    public void inc(String key) {
        Node n = nodes.getOrDefault(key, new Node(key, 0));
        int c = ++n.count;
        //if not new key
        if(c != 1){
            if(c > tail.prev.count){
                delete(n);
                n.next = tail;
                n.prev = tail.prev;
                tail.prev.next = n;
                tail.prev = n;
            }else{
                updateInc(n);
            }
        }else { //new key
            nodes.put(key,n);
            n.prev = head;
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
        }
    }
    
    public void dec(String key) {
        Node n = nodes.get(key);
        if (--n.count == 0) {
            nodes.remove(key);
            delete(n);
        } else {
            updateDec(n);
        }
    }
    
    public String getMaxKey() {
        return head.next == tail ? "" : tail.prev.key;
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

//  class AllOne {
//     Map<String, Integer> keyCount;
//     TreeMap<Integer, Set<String>> countKeys;
//     public AllOne() {
//         keyCount = new HashMap<>();
//         countKeys = new TreeMap<>();
//     }
    
//     public void inc(String key) {
//         int oldCount = keyCount.getOrDefault(key,0);
//         if (keyCount.containsKey(key)) {
//             countKeys.get(oldCount).remove(key);
//             if (countKeys.get(oldCount).isEmpty()) {
//                 countKeys.remove(oldCount);
//             }
//         }
//         keyCount.put(key, oldCount + 1);
//         countKeys.computeIfAbsent(oldCount + 1, k -> new HashSet<>()).add(key);
//     }
    
//     public void dec(String key) {
//         int oldCount = keyCount.get(key);
//         countKeys.get(oldCount).remove(key);
//         if (countKeys.get(oldCount).isEmpty()) {
//             countKeys.remove(oldCount);
//         }
        
//         if (oldCount == 1) {
//            keyCount.remove(key); 
//         } else {
//             keyCount.put(key, oldCount -1);
//             countKeys.computeIfAbsent(oldCount - 1, k -> new HashSet<>()).add(key);
 
//         }

//     }
    
//     public String getMaxKey() {
//         if (keyCount.isEmpty()) return "";
//         return countKeys.lastEntry().getValue().iterator().next();
//     }
    
//     public String getMinKey() {
//         if (keyCount.isEmpty()) return "";
//         return countKeys.firstEntry().getValue().iterator().next();
//     }
// }

// /**
//  * Your AllOne object will be instantiated and called as such:
//  * AllOne obj = new AllOne();
//  * obj.inc(key);
//  * obj.dec(key);
//  * String param_3 = obj.getMaxKey();
//  * String param_4 = obj.getMinKey();
//  */
