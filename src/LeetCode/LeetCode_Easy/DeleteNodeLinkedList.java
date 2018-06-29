package LeetCode.LeetCode_Easy;

import ctci.LinkedList.List;

/**
 * Created by joetomjob on 6/21/18.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class DeleteNodeLinkedList {
    static ListNode a;
    static ListNode b;
    static ListNode c;
    static ListNode d;

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        a = new ListNode(4);
        b = new ListNode(4);
        c = new ListNode(4);
        d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;


    }
}
