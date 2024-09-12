import java.util.HashMap;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.val = data;
        this.right = null;
        this.left = null;
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
    // 3->3->5 +1==3->3->6
    public ListNode addOne(ListNode head) {
        // code here.
        head = reversLinkedList(head);
        ListNode current = head;
        int carry = 1;
        
        while (current != null) {
            int sum = current.val + carry;
            carry = sum / 10;
            current.val = sum % 10;
            
            if (current.next == null && carry > 0) {
                current.next = new ListNode(carry);
                carry = 0;
            }
            current = current.next;
        }
        
        head = reversLinkedList(head);
        return head;
    }

    private static ListNode reversLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
        // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(ListNode head) {
        // Add your code here.
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                int len=1;
                slow=slow.next;
                while(slow!=fast){
                    len++;
                    slow=slow.next;
                }
                return len;
            }
        }
        return 0;
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs =new HashSet<Integer>();
        for (int i : nums) {
            hs.add(i);
        }
        while(head!=null && hs.contains(head.val)){
            head=head.next;
        }
        if(head==null){
            return null;
        }
        ListNode temp=head;
        while (temp.next!=null) {
            if(hs.contains(temp.next.val)){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null){
            return false;
        }
        return (getPath(head, root) || isSubPath(head, root.right)) || isSubPath(head, root.left);
    }

    private boolean getPath(ListNode head, TreeNode root) {
        if (head==null ){
            return true;
        }if ( root==null) {
            return false;
        }
        if (head.val==root.val) {
            return getPath(head.next,root.left)|| getPath(head.next,root.right);
        }
        return false;
    }
    
    public boolean isSubPath2(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }

    boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        if(cur == null) return true;
        if(root == null) return false;
        if(cur.val == root.val) cur = cur.next;
        else if (head.val == root.val) head = head.next;
        else cur = head;
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res=new ListNode[k];
        int len=getLen(head);
        int s=len/k;
        int rem=len%k;
        ListNode temp=head;
        for (int i = 0; i < k; i++) {
            ListNode newNode=new ListNode(0);
            ListNode trav=newNode;
            int n=s;
            if(rem>0){
                rem--;
                n++;
            }
            while(n>0){
                n--;
                trav.next=new ListNode(temp.val);
                trav=trav.next;
                temp=temp.next;
            }
            res[i]=newNode.next;
        }
        return res;
    }

    private int getLen(ListNode head) {
        if(head==null){
            return 0;
        }
        int c=0;
        while(head!=null){
            c++;
            head=head.next;
        }
        return c;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        while (temp!=null && temp.next!=null) {
            ListNode curr=temp.next;
            temp.next=new ListNode(GCD(temp.val,temp.next.val));
            temp.next.next=curr;
            temp=temp.next.next;
        }
        return head;
    }

    private int GCD(int a, int b) {
        if(b==0){
            return a;
        }
        return GCD(b, a%b);
    }
    int getMiddle(Node head) {
        // Your code here.
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }

}
