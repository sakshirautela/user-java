public ListNode swapNodes(ListNode head, int k) {

        int n=countNode(head)-k;
        //int i=1;
        ListNode current=head;

        ListNode first=head,second=head;
        //int i=1;                                                           
        while(k>0){
            first=current;
            current=current.next;
            k--;
        }
        while(current!=null){
            current=current.next;
            second=second.next;

        }

        //swapping
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        return head;

    }