package problemsolvingIII;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteNodeswithGreateronRight {
    static void main() {

    }
    Node compute(Node head) {
        // code here
        Node result = new Node(0);
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
//            head = head.next;
        }
        for(int  i=list.size()-1;i>=1;i--){
            if(list.get(i)>list.get(i-1)){
                list.remove(i-1);
            }
        }
        Node root=result;
        for(int i=0;i<list.size();i++){
//            result.next=new Node(list.get(i));
//            result=result.next;
        }
//        return root.next;
        return root;
    }
}
