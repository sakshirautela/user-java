import java.util.*;

import org.w3c.dom.Node;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node npx;

        public Node(int x) {
            data = x;
            npx = null;
        }
    }

    static class Node2 {
        int data;
        DoublyLinkedList.Node2 right;
        DoublyLinkedList.Node2 down;

        public Node2(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    // function should insert the data to the front of the list
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        newNode.npx = head;
        return newNode;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here.
        Node curr = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.data);
            curr = curr.npx;
        }
        return list;
    }

    public static void main(String args[]) {
        Node node = new Node(0);
        insert(node, 5);
        System.out.println(getList(node));
    }

    static Node2 construct(int arr[][]) {
        // Add your code here.
        int n=arr.length;
        Node2[][] mat=new Node2[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j]=new Node2(arr[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j<n-1){
                    mat[i][j].right=mat[i][j+1];
                }
                if(i<n-1){
                    mat[i][j].down=mat[i+1][j];
                }
            }
        }
        return mat[0][0];
    }
}
