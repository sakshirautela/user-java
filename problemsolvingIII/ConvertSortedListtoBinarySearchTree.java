package problemsolvingIII;

import org.w3c.dom.traversal.TreeWalker;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
    static void main() {

    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        return buildTree(list,n,0);
    }

    private TreeNode buildTree(List<Integer> list, int r, int l) {
        if(r<l){
            return null;
        }
        int mid = (r + l) / 2;
        return new TreeNode(list.get(mid),buildTree(list,l,mid-1),buildTree(list,mid+1,r));
    }
}
