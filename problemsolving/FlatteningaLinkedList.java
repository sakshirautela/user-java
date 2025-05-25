import java.util.ArrayList;
import java.util.Collections;

public class FlatteningaLinkedList{
    static class Node{
        int data;
        Node next;
        Node bottom;
        Node(int data){
            this.data=data;
            this.next=null;
            this.bottom=null;
        }
    }
    public static void main(String[] args) {
        
    }
    Node flatten(Node root) {
        // code here
       ArrayList<Integer> al=new ArrayList<Integer>();
        Node temp=root;
        while (temp!=null) {
            Node b=temp;
            
            while (b!=null) {
                al.add(b.data);
                b=b.bottom;
            }
            temp=temp.next;
        }
        Collections.sort(al);
        Node newNode=new Node(0);
        root=newNode;
        for (int i : al) {
            newNode.bottom=new Node(i);
            newNode=newNode.bottom;
        }
        return root.bottom;
    }
}