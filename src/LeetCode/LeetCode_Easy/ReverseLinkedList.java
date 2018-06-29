package LeetCode.LeetCode_Easy;

import ctci.LinkedList.List;

/**
 * Created by joetomjob on 6/21/18.
 */
public class ReverseLinkedList {
    static ListNode a;
    static ListNode b;
    static ListNode c;
    static ListNode d;
    static ListNode e;

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null){
            ListNode curr = new ListNode(temp.val);
            curr.next = prev;
            prev = curr;
            temp = temp.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        a = new ListNode(1);
        b = new ListNode(2);
        c = new ListNode(3);
        d = new ListNode(4);
        e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ReverseLinkedList r = new ReverseLinkedList();
        System.out.println(r.reverseList(a).val);
    }
}
