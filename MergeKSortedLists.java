package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]==null){
                continue;
            }
            ListNode temp=lists[i];
            while (temp!= null) {
                list.add(temp.val);
                temp=temp.next;
            }

        }
        if (list.size()==0) {
            return null;
        }
        Collections.sort(list);
        System.out.println(list);
        ListNode lst=new ListNode(list.get(0));
        ListNode temp=lst;
        for (int i = 1; i < list.size(); i++) {
            lst.next=new ListNode(list.get(i));
            lst=lst.next;
        }
        return temp;
    }
    public static void main(String args[]){
         // Create an array of ListNode objects
         ListNode[] listNodes = new ListNode[3];

         // Initialize ListNode objects
         listNodes[0] = new ListNode(1);
         listNodes[1] = new ListNode(2);
         listNodes[2] = new ListNode(3);
 
         // Link the nodes
         listNodes[0].next = listNodes[1];
         listNodes[1].next = listNodes[2];
        System.out.println(listNodes);
    }
}