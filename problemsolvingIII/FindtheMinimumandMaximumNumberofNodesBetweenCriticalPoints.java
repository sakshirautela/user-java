package problemsolvingIII;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {
    static void main() {
        int[] res=nodesBetweenCriticalPoints(new ListNode(0));
    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res={-1,-1};
        if (head == null || head.next == null || head.next.next == null) {
            return res;
        }

        int current=1;
        int first =-1;
        int initial=-1;
        int minDiff=Integer.MAX_VALUE;
        ListNode prev=head;
        ListNode  curr=head.next;
        ListNode next=head.next.next;
        while(next != null) {
            if((prev.val<curr.val && curr.val>next.val)||(prev.val>curr.val && curr.val<next.val)) {
                if(initial==-1){
                    initial=current;
                }
                if(first !=-1){
                    minDiff=Math.min(minDiff,current- first);
                }
                first =current;
            }
            prev=prev.next;
            curr=curr.next;
            next=next.next;
            current++;
        }
        if(minDiff!=Integer.MAX_VALUE){
            res[0]=minDiff;
            res[1]= first -initial;
        }
        return res;
    }
}
